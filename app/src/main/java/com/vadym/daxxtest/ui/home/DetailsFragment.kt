package com.vadym.daxxtest.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.vadym.daxxtest.R
import com.vadym.daxxtest.databinding.FragmentDetailsBinding
import com.vadym.daxxtest.di.impl.injectViewModel
import com.vadym.daxxtest.model.NewsItem
import com.vadym.daxxtest.ui.bindImageFromUrl
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var detailsViewModel: DetailsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        AndroidSupportInjection.inject(this)
        detailsViewModel = injectViewModel(viewModelFactory)

        context ?: return binding.root
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val item = arguments?.getParcelable<NewsItem>("id_detail")
        binding.viewModel = detailsViewModel
        binding.apply { newsItem = item }

        bindImageFromUrl(binding.newsImage, item!!.newsContent.imageThumb)


        binding.buttonEstimate.setOnClickListener {
            findNavController().navigate(R.id.action_detailsFragment_to_estimateFragment,
                    bundleOf("id_estimate" to item))
        }
    }
}
