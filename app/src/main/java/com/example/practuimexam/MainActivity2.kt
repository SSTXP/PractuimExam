package com.example.practuimexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.isDigitsOnly

class MainActivity2 : AppCompatActivity() {
    private val days = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    private val morningTimes = Array(7) { 0 }
    private val afternoonTimes = Array(7) { 0 }
    private val notes = Array(7) { "" }



  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val moveScreen3: Button = findViewById(R.id.moveScreen3)
        val splashScreen: Button = findViewById(R.id.splashScreen)
        val clearButton: Button = findViewById(R.id.clearButton)
        val minValues : EditText = findViewById(R.id.minValues)
        val maxValues : EditText = findViewById(R.id.maxValues)
        val conditionWeather : EditText = findViewById(R.id.conditionWeather)





        splashScreen.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
         clearButton.setOnClickListener {
           minValues.text.clear()
           maxValues.text.clear()
           conditionWeather.text.clear()

         }


      moveScreen3.setOnClickListener {
          val intent = Intent(this, MainActivity3::class.java)
          startActivity(intent)
      }

  }

    private fun validateInputs(): Boolean {
        for (i in days.indices) {
            val minId = resources.getIdentifier("${days[i].toLowerCase()}_morning", "id", packageName)
            val maxId = resources.getIdentifier("${days[i].toLowerCase()}_afternoon", "id", packageName)
            val conditionId = resources.getIdentifier("${days[i].toLowerCase()}_note", "id", packageName)

            val minText = findViewById<EditText>(minId).text.toString()
            val maxText = findViewById<EditText>(maxId).text.toString()
            val conditionText = findViewById<EditText>(conditionId).text.toString()

            if (minText.isEmpty() || maxText.isEmpty() || !minText.isDigitsOnly() || !maxText.isDigitsOnly()) {
                Toast.makeText(this, "Error: Use minutes for time spent on device", Toast.LENGTH_SHORT).show()
                return false
            }

            morningTimes[i] = minText.toInt()
            afternoonTimes[i] = maxText.toInt()
            notes[i] = conditionText
        }
        return true
    }

    private fun clearInputs() {
        for (i in days.indices) {
            val minId = resources.getIdentifier("${days[i].toLowerCase()}_morning", "id", packageName)
            val maxId = resources.getIdentifier("${days[i].toLowerCase()}_afternoon", "id", packageName)
            val conditionId = resources.getIdentifier("${days[i].toLowerCase()}_note", "id", packageName)

            findViewById<EditText>(minId).text.clear()
            findViewById<EditText>(maxId).text.clear()
            findViewById<EditText>(conditionId).text.clear()
        }

    }
 }
