package com.example.confirmedchallenge.homepage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.confirmedchallenge.R
import com.example.confirmedchallenge.databinding.FragmentHomePageBinding
import com.example.confirmedchallenge.databinding.GridProductItemBinding

class HomePageFragment : Fragment() {

    private val viewModel: HomePageViewModel by lazy {
        ViewModelProvider(this).get(HomePageViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = GridProductItemBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        return binding.root
    }

}