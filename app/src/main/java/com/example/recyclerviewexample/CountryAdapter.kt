package com.example.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter(private val listener: (Country) -> Unit): ListAdapter<Country, CountryAdapter.ViewHolder>(DiffCallback()){

    inner class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        private val countryFlag: ImageView = view.findViewById(R.id.country_flag)
        private val countryName: TextView = view.findViewById(R.id.country_name)
        private val capitalCity: TextView = view.findViewById(R.id.country_capital)

        init{
            itemView.setOnClickListener{
                listener.invoke(getItem(adapterPosition))
            }
        }

        fun bind(countryData: Country) {
            with(countryData) {
                countryFlag.setImageResource(flagId)
                countryName.text = name
                this@ViewHolder.capitalCity.text = capitalCity
            }
        }
    }

        override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {

        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.country_item, parent, false)

        return ViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class DiffCallback : DiffUtil.ItemCallback<Country>() {
    override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
        return oldItem.code == newItem.code
    }

    override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
        return oldItem == newItem
    }
}