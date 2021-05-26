package com.example.confirmedchallenge.review

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.confirmedchallenge.databinding.FragmentReviewBinding


class ReviewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application
        val binding = FragmentReviewBinding.inflate(inflater)

        binding.lifecycleOwner = this

        val productItem = ReviewFragmentArgs.fromBundle(arguments).selectedProduct
        val viewModelFactory = ReviewViewModelFactory(productItem, application)

        binding.viewModel = ViewModelProvider(this, viewModelFactory).get(ReviewViewModel::class.java)

        binding.viewModel.createNewReviewObject()

        binding.viewModel.eventCloseScreen.observe(viewLifecycleOwner, Observer { close ->
            close?.let {
                if (it) {
                    findNavController().navigateUp()
                    binding.viewModel.onEventCloseComplete()
                }
            }
        })

        return binding.root
    }
}