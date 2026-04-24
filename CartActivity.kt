package com.example.saimobilerepair.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.*
import com.example.saimobilerepair.R

class CartActivity : Activity() {

    lateinit var cartList: ListView
    lateinit var btnOrder: Button
    lateinit var totalText: TextView
    lateinit var nameInput: EditText
    lateinit var phoneInput: EditText
    lateinit var addressInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        // INIT VIEWS
        cartList = findViewById(R.id.cartList)
        btnOrder = findViewById(R.id.btnOrder)
        totalText = findViewById(R.id.totalText)

        nameInput = findViewById(R.id.nameInput)
        phoneInput = findViewById(R.id.phoneInput)
        addressInput = findViewById(R.id.addressInput)

        val cart = MainActivity.cart

        // ADAPTER (simple — no custom needed)
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            cart
        )
        cartList.adapter = adapter

        // CALCULATE TOTAL
        var total = 0

        for (item in cart) {
            item?.let {
                try {
                    val priceStr = it.substring(it.lastIndexOf("₹") + 1)
                    total += priceStr.toInt()
                } catch (e: Exception) {}
            }
        }

        totalText.text = "Total: ₹$total"

        val finalTotal = total

        // BUTTON CLICK
        btnOrder.setOnClickListener {

            val name = nameInput.text.toString()
            val phone = phoneInput.text.toString()
            val address = addressInput.text.toString()

            if (name.isEmpty() || phone.isEmpty() || address.isEmpty()) {
                Toast.makeText(this, "Please fill all details", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // BUILD ITEMS STRING
            val itemsBuilder = StringBuilder()
            for (item in cart) {
                itemsBuilder.append(item).append("\n")
            }

            val intent = Intent(this, OrderSummaryActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("phone", phone)
            intent.putExtra("address", address)
            intent.putExtra("items", itemsBuilder.toString())
            intent.putExtra("total", finalTotal)

            startActivity(intent)
        }
    }
}