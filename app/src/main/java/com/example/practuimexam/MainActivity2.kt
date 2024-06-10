package com.example.practuimexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.isDigitsOnly

class MainActivity2 : AppCompatActivity() {
    private val days = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    private val min = Array(7) {0}
    private val max = Array(7) {0}
    private val condition = Array(7){""}



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
             //clear text from all edittext blocks

         }


      moveScreen3.setOnClickListener {
          val intent = Intent(this, MainActivity3::class.java)
          startActivity(intent)
          //move to third screen

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
                Toast.makeText(this, "input minimum and maximum temperatures", Toast.LENGTH_SHORT).show()
                return false
                // if incorrect value is input an error message will pop up
            }

            min[i] = minText.toInt()
            max[i] = maxText.toInt()
            condition[i] = conditionText
        }
        return true
    }

    private fun clearInputs() {
        for (i in days.indices) {
            val minId = resources.getIdentifier("${days[i].toLowerCase()}_min", "id", packageName)
            val maxId = resources.getIdentifier("${days[i].toLowerCase()}_max", "id", packageName)
            val conditionId = resources.getIdentifier("${days[i].toLowerCase()}_condition", "id", packageName)

            findViewById<EditText>(minId).text.clear()
            findViewById<EditText>(maxId).text.clear()
            findViewById<EditText>(conditionId).text.clear()
        }

    }
 }
