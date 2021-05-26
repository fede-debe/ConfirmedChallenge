package com.example.confirmedchallenge.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.confirmedchallenge.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application
        val binding = FragmentDetailsBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val productItem = DetailsFragmentArgs.fromBundle(arguments!!).selectedProduct

        val viewModelFactory = DetailViewModelFactory(productItem, application)
        binding.viewModel = ViewModelProvider(
            this, viewModelFactory).get(DetailViewModel::class.java)

        binding.viewModel.navigateToAddReview.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                this.findNavController().navigate(DetailsFragmentDirections.actionDetailsFragmentToReviewFragment(it))
                binding.viewModel.displayAddReviewComplete()
            }
        })

        return binding.root
    }
}