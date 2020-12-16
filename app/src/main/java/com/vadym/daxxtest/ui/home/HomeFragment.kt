package com.vadym.daxxtest.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.vadym.daxxtest.R
import com.vadym.daxxtest.databinding.FragmentHomeBinding
import com.vadym.daxxtest.di.impl.injectViewModel
import com.vadym.daxxtest.model.NewsItem
import com.vadym.daxxtest.ui.adapters.ComplicatedListAdapter
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class HomeFragment : Fragment(), ComplicatedListAdapter.OnItemClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var mAdapter: ComplicatedListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )
        AndroidSupportInjection.inject(this)
        homeViewModel = injectViewModel(viewModelFactory)
        binding.viewModel = homeViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.recyclerView.setHasFixedSize(true)
        homeViewModel.oPage = 1
        homeViewModel.oLimit = 20

        homeViewModel.newsList.observe(viewLifecycleOwner, Observer { newsResponse ->

            mAdapter = ComplicatedListAdapter(newsResponse.newsList, this)
            binding.recyclerView.adapter = mAdapter

            binding.recyclerView.scrollToPosition(homeViewModel.scrollPosition.value!!)

            homeViewModel.isShowProgress.value = View.GONE
        })

        return binding.root
    }

    override fun onItemClick(item: NewsItem) {
        findNavController().navigate(
            R.id.action_homeFragment_to_detailsFragment,
            bundleOf("id_detail" to item)
        )
    }

}