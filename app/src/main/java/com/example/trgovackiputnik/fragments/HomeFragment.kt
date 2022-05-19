package com.example.trgovackiputnik.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.trgovackiputnik.R
import com.example.trgovackiputnik.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.homeImage.setImageResource(R.drawable.map)
        binding.homeButton.setOnClickListener{
            view.findNavController().navigate(R.id.action_homeFragment_to_citiesFragment)
        }
        return view
    }

}