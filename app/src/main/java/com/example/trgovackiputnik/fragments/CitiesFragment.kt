package com.example.trgovackiputnik.fragments

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trgovackiputnik.R
import com.example.trgovackiputnik.adapters.CitiesAdapter
import com.example.trgovackiputnik.data.Cities
import com.example.trgovackiputnik.databinding.FragmentCitiesBinding
import com.example.trgovackiputnik.data.Global


class CitiesFragment : Fragment() {
    private var _binding: FragmentCitiesBinding? = null
    private val binding get() = _binding!!

    private lateinit var newRecyclerview: RecyclerView
    private lateinit var  citiesList: ArrayList<Cities>
    private lateinit var cities : MutableList<String>
    private lateinit var country : String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCitiesBinding.inflate(inflater, container, false)
        val view = binding.root

        cities = Global.logic.GetAllCitiesNames()

        country = "Bosna i Hercegovina"

        newRecyclerview = binding.citiesRecyclerview
        newRecyclerview.layoutManager = LinearLayoutManager(activity)
        newRecyclerview.setHasFixedSize(true)
        citiesList = arrayListOf<Cities>()
        getUserData()
        return view
    }

    private fun getUserData() {
        for(i in cities.indices) {
            val city = Cities(cities[i], country)
            citiesList.add(city)
        }
        newRecyclerview.adapter = CitiesAdapter(citiesList)
    }

}