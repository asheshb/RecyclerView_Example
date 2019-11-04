package com.example.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter(private val listener: (Country) -> Unit): RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(){

    var countryData = arrayOf<Country>()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    inner class CountryViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val countryFlag: ImageView = view.findViewById(R.id.country_flag)
        val countryName: TextView = view.findViewById(R.id.country_name)
        val capitalCity: TextView = view.findViewById(R.id.country_capital)

        init{
            itemView.setOnClickListener{
                listener.invoke(countryData[adapterPosition])
            }
        }

        fun bind(countryData: Country){
            with(countryData){
                countryFlag.setImageResource(flagId)
                countryName.text = name
                this@CountryViewHolder.capitalCity.text = capitalCity
            }
        }
    }

    override fun getItemCount() = countryData.size

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): CountryViewHolder {

        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.country_item, parent, false)

        return CountryViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countryData[position])
    }

    override fun getItemId(position: Int): Long {
        return countryData[position].code.hashCode().toLong()
    }

}