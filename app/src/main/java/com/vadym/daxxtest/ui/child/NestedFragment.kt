package com.vadym.daxxtest.ui.child

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.vadym.daxxtest.R
import com.vadym.daxxtest.databinding.FragmentNestedBinding
import com.vadym.daxxtest.di.impl.injectViewModel
import com.vadym.daxxtest.ui.adapters.NestedFragmentAdapter
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class NestedFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var galleryViewModel: NestedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentNestedBinding>(
            inflater,
            R.layout.fragment_nested,
            container,
            false
        )
        AndroidSupportInjection.inject(this)
        galleryViewModel = injectViewModel(viewModelFactory)
        binding.viewModel = galleryViewModel

        galleryViewModel.text.observe(viewLifecycleOwner, {
            Toast.makeText(context, "Nested Fragment : $it", Toast.LENGTH_LONG).show()
        })

        binding.viewPager.adapter = NestedFragmentAdapter(childFragmentManager)
        binding.pagerTabStrip.setupWithViewPager(binding.viewPager)

        return binding.root
    }

}