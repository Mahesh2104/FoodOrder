package com.example.foodorder

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnPlaceOrder).setOnClickListener {
            startActivity(Intent(this, PlaceOrderActivity::class.java))
        }
        findViewById<Button>(R.id.btnContact).setOnClickListener {
            startActivity(Intent(this, ContactActivity::class.java))
        }
        findViewById<Button>(R.id.btnNotification).setOnClickListener {
            startActivity(Intent(this, NotificationActivity::class.java))
        }
    }
}