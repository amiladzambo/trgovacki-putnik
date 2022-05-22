package com.example.trgovackiputnik.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.trgovackiputnik.databinding.FragmentCityDetailsBinding


class CityDetailsFragment : Fragment() {
    private var _binding: FragmentCityDetailsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCityDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        val packageManager = requireActivity().packageManager
        Log.i("Created CityDetails", "City Details View Created")

        binding.findOnMap.setOnClickListener{
            val gmmIntentUri = Uri.parse("geo:37.7749,-122.4192")
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = gmmIntentUri
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }

        }

        binding.sendMessage.setOnClickListener{
            val sendIntent: Intent = Intent(Intent.ACTION_SEND).apply {
                putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            if (sendIntent.resolveActivity(packageManager) != null) {
                startActivity(shareIntent)
            }
        }
        return view
    }

    override fun onStop() {
        super.onStop()
        Log.i("CityDetails", "City Details View Stoped")
    }

    override fun onPause() {
        super.onPause()
        Log.i("CityDetails", "City Details View Paused")
    }

    override fun onResume() {
        super.onResume()
        Log.i("CityDetails", "City Details View Resumed")
    }
}