package com.example.recyclerviewexample

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter: RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(){

    var countryData = arrayOf<Country>()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    class CountryViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        private val countryFlag: ImageView = view.findViewById(R.id.country_flag)
        private val countryName: TextView = view.findViewById(R.id.country_name)
        private val capitalCity: TextView = view.findViewById(R.id.country_capital)
    }

    override fun getItemCount() = countryData.size

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): CountryViewHolder {
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

    }

}