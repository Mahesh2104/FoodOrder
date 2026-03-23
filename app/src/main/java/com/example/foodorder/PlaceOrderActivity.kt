package com.example.foodorder

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random

class PlaceOrderActivity : AppCompatActivity() {
    private var quantity = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_order)

        val foods = arrayOf("Pizza", "Burger", "Pasta", "Biriyani", "Sandwich", "Shawarma", "Noodles")
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, foods)
        val autoCompleteFood = findViewById<AutoCompleteTextView>(R.id.autoCompleteFood)
        autoCompleteFood.setAdapter(adapter)

        val tvQuantity = findViewById<TextView>(R.id.tvQuantity)
        val btnPlus = findViewById<ImageButton>(R.id.btnPlus)
        val btnMinus = findViewById<ImageButton>(R.id.btnMinus)

        btnPlus.setOnClickListener {
            quantity++
            tvQuantity.text = quantity.toString()
        }

        btnMinus.setOnClickListener {
            if (quantity > 1) {
                quantity--
                tvQuantity.text = quantity.toString()
            }
        }

        findViewById<Button>(R.id.btnSubmitOrder).setOnClickListener { view ->
            val name = findViewById<EditText>(R.id.etName).text.toString()
            val food = autoCompleteFood.text.toString()
            val address = findViewById<EditText>(R.id.etAddress).text.toString()

            if (name.isEmpty() || food.isEmpty() || address.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                val orderId = Random.nextInt(100, 999)
                val summary = "Order #$orderId: $food x $quantity for $name"
                
                Snackbar.make(view, "Success! $summary", Snackbar.LENGTH_INDEFINITE)
                    .setAction("OK") {}
                    .show()
                
                // Clear fields after booking
                findViewById<EditText>(R.id.etName).text.clear()
                findViewById<EditText>(R.id.etAddress).text.clear()
                autoCompleteFood.text.clear()
                quantity = 1
                tvQuantity.text = "1"
            }
        }
    }
}
