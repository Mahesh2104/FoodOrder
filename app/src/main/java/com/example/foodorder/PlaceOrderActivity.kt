package com.example.foodorder

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random

class PlaceOrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_order)

        val spinner = findViewById<Spinner>(R.id.spinnerFood)
        val foods = arrayOf("Pizza", "Burger", "Pasta", "Biriyani", "Sandwich","Shawarma","Noodles")
        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, foods)

        findViewById<Button>(R.id.btnSubmitOrder).setOnClickListener { view ->
            val name = findViewById<EditText>(R.id.etName).text.toString()
            val qty = findViewById<EditText>(R.id.etQuantity).text.toString()
            val address = findViewById<EditText>(R.id.etAddress).text.toString()

            if (name.isEmpty() || qty.isEmpty() || address.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                val orderId = Random.nextInt(0, 999)
                val summary = "Order #$orderId: ${spinner.selectedItem} x $qty for $name"
                
                // Show a dialog or snackbar with the Order ID
                Snackbar.make(view, "Success! $summary", Snackbar.LENGTH_INDEFINITE)
                    .setAction("OK") {}
                    .show()
                
                // Clear fields after booking
                findViewById<EditText>(R.id.etName).text.clear()
                findViewById<EditText>(R.id.etQuantity).text.clear()
                findViewById<EditText>(R.id.etAddress).text.clear()
            }
        }
    }
}