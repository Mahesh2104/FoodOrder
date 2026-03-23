package com.example.foodorder

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        val branches = arrayOf("Peelamedu - 9876543210", "Gandhipuram - 8877665544", "Airport - 9900112233")
        val phoneNumbers = arrayOf("9876543210", "8877665544", "9900112233")

        val listView = findViewById<ListView>(R.id.listView)
        
        // Custom adapter to use item_contact layout
        val adapter = object : ArrayAdapter<String>(this, R.layout.item_contact, R.id.tvContactInfo, branches) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getView(position, convertView, parent)
                return view
            }
        }
        
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${phoneNumbers[position]}")
            startActivity(intent)
        }
    }
}