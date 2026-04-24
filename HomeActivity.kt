package com.example.saimobilerepair.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.saimobilerepair.R

class HomeActivity : Activity() {
    var enterBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        enterBtn = findViewById<Button>(R.id.enterBtn)

        enterBtn!!.setOnClickListener(View.OnClickListener { v: View? ->
            startActivity(Intent(this@HomeActivity, MainActivity::class.java))
        })
    }
}