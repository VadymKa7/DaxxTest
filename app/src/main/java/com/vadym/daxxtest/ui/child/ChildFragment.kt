package com.vadym.daxxtest.ui.child

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.vadym.daxxtest.R
import com.vadym.daxxtest.databinding.FragmentChildBinding
import com.vadym.daxxtest.di.impl.injectViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class ChildFragment : Fragment(), OnClickListener {

    private var position: Int = 0

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var childViewModel: ChildViewModel

    override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      state: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentChildBinding>(
          inflater,
          R.layout.fragment_child,
          container,
          false
        )
        AndroidSupportInjection.inject(this)
        childViewModel = injectViewModel(viewModelFactory)
        binding.viewModel = childViewModel


        position = arguments?.getInt(POSITION_KEY) ?: 0

        binding.textViewPosition.apply {
            text = "FragmentPage $position"
            setOnClickListener(this@ChildFragment)
        }

        return binding.root
    }

    override fun onClick(v: View) {
        Toast.makeText(v.context, "Clicked Position: $position", Toast.LENGTH_LONG).show()
    }

    companion object {
        const val POSITION_KEY = "position"
        fun newInstance(args: Bundle): ChildFragment = ChildFragment().apply {
            arguments = args

        }
    }
}
