package com.vadym.daxxtest.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.vadym.daxxtest.R
import com.vadym.daxxtest.databinding.FragmentEstimateBinding
import com.vadym.daxxtest.di.impl.injectViewModel
import com.vadym.daxxtest.model.NewsItem
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class EstimateFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var estimateViewModel: EstimateViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentEstimateBinding>(
            inflater, R.layout.fragment_estimate,
            container, false
        )

        AndroidSupportInjection.inject(this)
        estimateViewModel = injectViewModel(viewModelFactory)
        binding.viewModel = estimateViewModel


        val item = arguments?.getParcelable<NewsItem>("id_estimate")

        // this example shows the only one opportunity to send data to another fragment, but we don't
        // save this variable in the object, but we can if we will want
        binding.ratingBar.rating = item?.estimate!!.toFloat()
        binding.ratingBar.onRatingBarChangeListener =
            RatingBar.OnRatingBarChangeListener { _, _, _ ->
                item.estimate = binding.ratingBar.rating
                findNavController().navigate(
                    R.id.action_estimateFragment_to_detailsFragment,
                    bundleOf("id_detail" to item),
                )
            }


        return binding.root
    }

}