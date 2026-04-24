package com.example.saimobilerepair.activities

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.saimobilerepair.R

class OrderSummaryActivity : Activity() {
    var summaryText: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        summaryText = findViewById<TextView>(R.id.summaryText)

        val name = getIntent().getStringExtra("name")
        val phone = getIntent().getStringExtra("phone")
        val address = getIntent().getStringExtra("address")
        val items = getIntent().getStringExtra("items")
        val total = getIntent().getIntExtra("total", 0)

        val summary =
            "Sai Mobile Repair Shop\n" +
                    "--------------------------------------\n\n" +
                    "Name: " + name + "\n" +
                    "Phone: " + phone + "\n" +
                    "Address: " + address + "\n\n" +
                    "Items:\n" + items +
                    "\nTotal: ₹" + total +
                    "\n\n🎉 Order Placed Successfully!"
        summaryText!!.setText(summary)
        Toast.makeText(this, "Order Placed Successfully", Toast.LENGTH_LONG).show()
    }
}