package com.example.confirmedchallenge.homepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.confirmedchallenge.databinding.FragmentHomePageBinding

class HomePageFragment : Fragment() {

    private val viewModel: HomePageViewModel by lazy {
        ViewModelProvider(this).get(HomePageViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentHomePageBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.rvProductsList.adapter = PhotoGridAdapter(PhotoGridAdapter.OnClickListener{
            viewModel.displayProductDetails(it)
        })

        viewModel.navigateToSelectedProduct.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                this.findNavController().navigate(HomePageFragmentDirections.actionHomePageFragmentToDetailsFragment(it))
                viewModel.displayProductDetailsComplete()
            }
        })

        return binding.root
    }

}