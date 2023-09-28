package com.example.frontend

import android.content.Intent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class ScheduleSelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_selection)

        val cinemaNameTextView: TextView = findViewById(R.id.cinemaNameTextView)
        val cinemaLocationTextView: TextView = findViewById(R.id.cinemaLocationTextView)
        val functionSpinner: Spinner = findViewById(R.id.functionSpinner)
        val functionPriceTextView: TextView = findViewById(R.id.functionPriceTextView)
        val totalPriceTextView: TextView = findViewById(R.id.totalPriceTextView)

        cinemaNameTextView.text = " "
        cinemaLocationTextView.text = " "

        val functionOptions = resources.getStringArray(R.array.function_options)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, functionOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        functionSpinner.adapter = adapter

        functionSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                val selectedFunction = functionOptions[position]
                val functionPrices = resources.getStringArray(R.array.function_prices)
                val price = functionPrices[position].toDoubleOrNull() ?: 0.0
                functionPriceTextView.text = "Precio de la Función: $${String.format("%.2f", price)}"


                val totalPrice = calculateTotalPrice(price)
                totalPriceTextView.text = "Total a Pagar: $${String.format("%.2f", totalPrice)}"
            }

            override fun onNothingSelected(parentView: AdapterView<*>) {

            }
        }

        val paymentButton: Button = findViewById(R.id.btPayment)
        paymentButton.setOnClickListener {
            val intent = Intent(this, PaymentActivity::class.java)
            startActivity(intent)
        }
        val backButton: ImageButton = findViewById(R.id.btBack)
        backButton.setOnClickListener {
            val intent = Intent(this, FunctionSelectionActivity::class.java)
            startActivity(intent)
        }

    }
    private fun calculateTotalPrice(price: Double): Double {
        // Puedes agregar lógica adicional aquí si es necesario, como aplicar descuentos, etc.
        return price
    }
}