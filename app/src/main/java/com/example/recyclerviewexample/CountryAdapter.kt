package com.example.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter: RecyclerView.Adapter<CountryAdapter.ViewHolder>(){

    var countryData = arrayOf<Country>()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val countryFlag: ImageView = view.findViewById(R.id.country_flag)
        val countryName: TextView = view.findViewById(R.id.country_name)
        val capitalCity: TextView = view.findViewById(R.id.country_capital)
    }

    override fun getItemCount() = countryData.size

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {

        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.country_item, parent, false)

        return ViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            countryFlag.setImageResource(countryData[position].flagId)
            countryName.text = countryData[position].name
            capitalCity.text = countryData[position].capitalCity
        }
    }

    override fun getItemId(position: Int): Long {
        return countryData[position].code.hashCode().toLong()
    }

}