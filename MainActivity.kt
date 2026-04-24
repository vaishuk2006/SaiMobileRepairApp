package com.example.saimobilerepair.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.saimobilerepair.R
import android.graphics.Typeface
import android.view.ViewGroup
import android.widget.TextView



class MainActivity : AppCompatActivity() {
    var listView: ListView? = null
    var btnCart: Button? = null

    companion object {
        val cart = ArrayList<String>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById<ListView>(R.id.listView)
        btnCart = findViewById<Button>(R.id.btnCart)

        val listView = findViewById<ListView>(R.id.listView)

        val services = ArrayList<String?>()

        services.add("----- REPAIR SERVICES -----")

        services.add("Screen Replacement - ₹1500")
        services.add("Battery Change - ₹800")
        services.add("Charging Port Repair - ₹500")
        services.add("Speaker Fix - ₹400")
        services.add("")

        services.add("----- PHONE COVERS -----")

        services.add("Silicone Cover - ₹199")
        services.add("Designer Back Cover - ₹299")
        services.add("Transparent Cover - ₹149")
        services.add("Premium Hard Case - ₹399")
        services.add("")

        services.add("----- CHARGERS -----")

        services.add("Fast Charger 20W - ₹499")
        services.add("Type-C Charger - ₹299")
        services.add("Wireless Charger - ₹999")
        services.add("Original Adapter - ₹799")
        services.add("")

        val adapter = object : ArrayAdapter<String>(
            this,
            R.layout.item_with_button,
            services
        ) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

                val view = layoutInflater.inflate(R.layout.item_with_button, null)

                val text = view.findViewById<TextView>(R.id.itemText)
                val btnAdd = view.findViewById<Button>(R.id.btnAdd)

                val item = getItem(position)

                text.text = item

                // Hide button for headings
                if (item.isNullOrEmpty() || item.contains("----")) {
                    btnAdd.visibility = View.GONE
                    text.setTypeface(null, Typeface.BOLD)
                } else {
                    btnAdd.visibility = View.VISIBLE

                    btnAdd.setOnClickListener {
                        MainActivity.cart.add(item)
                        Toast.makeText(this@MainActivity, "Added to Cart", Toast.LENGTH_SHORT).show()
                    }
                }


                val btnCart = findViewById<Button>(R.id.btnCart)

                btnCart.setOnClickListener {
                    val intent = Intent(this@MainActivity, CartActivity::class.java)
                    startActivity(intent)
                }

                return view
            }
        }

        listView.adapter = adapter
    }
}