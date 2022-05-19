package com.example.trgovackiputnik.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.trgovackiputnik.data.Cities
import com.example.trgovackiputnik.R

class CitiesAdapter(private val citiesList : ArrayList<Cities>) :
    RecyclerView.Adapter<CitiesAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_city, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = citiesList[position]
        holder.cityName.text = currentItem.cityName
        holder.countryName.text = currentItem.country
    }

    override fun getItemCount(): Int {
        return citiesList.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cityName: TextView = itemView.findViewById(R.id.cityName)
        val countryName : TextView = itemView.findViewById(R.id.countryName)
    }
}

