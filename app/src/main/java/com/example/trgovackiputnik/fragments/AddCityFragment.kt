package com.example.trgovackiputnik.fragments

import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.trgovackiputnik.databinding.FragmentAddCityBinding

class AddCityFragment : Fragment() {
    private var _binding: FragmentAddCityBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddCityBinding.inflate(inflater, container, false)
        val view = binding.root

        val cityName : Editable? = binding.cityName.text
        val cityLng : Editable?  = binding.cityLng.text
        val cityLan : Editable?  = binding.cityLng.text

        binding.addCityButton.setOnClickListener{
            Toast.makeText(context, cityName.toString(), Toast.LENGTH_SHORT).show();
        }

        return view

    }

}