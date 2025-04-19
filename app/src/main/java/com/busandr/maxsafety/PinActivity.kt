package com.busandr.maxsafety

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PinActivity : AppCompatActivity() {
    private val validPin = "1111"
    private var currentPin = ""
    private lateinit var textViewResult: TextView

    private fun comparePIN() {
        if (currentPin == validPin) {
            val intent = Intent(this, SwipeActivity::class.java)
            Log.i("this", "@!!!!!!!!!!!!!!!!")
            startActivity(intent)
        }
    }

    private fun addToInput(digit: String) {
        currentPin += digit
        updateDisplay(textViewResult)
        comparePIN()

    }

    private fun backspace() {
        if (currentPin.isNotEmpty()) {
            currentPin = currentPin.substring(0, currentPin.length - 1)
            updateDisplay(textViewResult)
            comparePIN()
        }
    }

    private fun updateDisplay(view: TextView) {
        view.text = currentPin
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pin)
        textViewResult = findViewById(R.id.textViewResult)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val button7: Button = findViewById(R.id.button7)
        val button8: Button = findViewById(R.id.button8)
        val button9: Button = findViewById(R.id.button9)
        val button0: Button = findViewById(R.id.button0)
        val buttonBackspace: Button = findViewById(R.id.buttonBackspace)

        button1.setOnClickListener { addToInput("1") }
        button2.setOnClickListener { addToInput("2") }
        button3.setOnClickListener { addToInput("3") }
        button4.setOnClickListener { addToInput("4") }
        button5.setOnClickListener { addToInput("5") }
        button6.setOnClickListener { addToInput("6") }
        button7.setOnClickListener { addToInput("7") }
        button8.setOnClickListener { addToInput("8") }
        button9.setOnClickListener { addToInput("9") }
        button0.setOnClickListener { addToInput("0") }

        buttonBackspace.setOnClickListener { backspace() }
    }
}