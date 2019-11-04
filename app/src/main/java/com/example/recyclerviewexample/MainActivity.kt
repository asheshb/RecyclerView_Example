package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

val countries = arrayOf(Country("ar", "Argentina", "Buenos Aires", R.drawable.ar),
    Country("au", "Australia", "Canberra", R.drawable.au),
    Country("be", "Belgium", "Brussels", R.drawable.be),
    Country("br", "Brazil", "Brasilia", R.drawable.br),
    Country("ca", "Canada", "Ottawa", R.drawable.ca),
    Country("ch", "Switzerland", "Bern", R.drawable.ch),
    Country("cn", "China", "Beijing", R.drawable.cn),
    Country("gr", "Greece", "Athens", R.drawable.gr),
    Country("in", "India", "New Delhi", R.drawable.`in`),
    Country("jp", "Japan", "Tokyo", R.drawable.jp),
    Country("kr", "South Korea", "Seoul", R.drawable.kr),
    Country("nl", "Netherlands", "Amsterdam", R.drawable.nl),
    Country("pt", "Portugal", "Lisbon", R.drawable.pt),
    Country("us", "USA", "Washington, D.C.", R.drawable.us),
    Country("za", "South Africa", "Cape Town", R.drawable.za))


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countryList = findViewById<RecyclerView>(R.id.country_list).apply {

            layoutManager = LinearLayoutManager(this@MainActivity)

            adapter = CountryAdapter{
                Toast.makeText(this@MainActivity, "Country: {${it.name}} was clicked",
                    Toast.LENGTH_SHORT).show()
            }.apply {
                setHasStableIds(true)
            }
            setHasFixedSize(true)
        }

        val showCountries = findViewById<Button>(R.id.show_countries)
        showCountries.setOnClickListener {
            (countryList.adapter as CountryAdapter).countryData = countries
        }
    }
}
