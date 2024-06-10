package com.example.practuimexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.text.isDigitsOnly

class MainActivity2 : AppCompatActivity() {

    private val days =
        arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    private val min = Array(7) { 0 }
    private val max = Array(7) { 0 }
    private val condition = Array(7) { "" }
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
            if (validateInputs()) {
                val intent = Intent(this,MainActivity3 ::class.java)
                intent.putExtra("Min values", min )
                intent.putExtra("Max values", max )
                intent.putExtra("weather condition", condition )
                startActivity(intent)
            }
       }
    }

 private fun validateInputs(): Boolean {
    for (i in days.indices) {
        val minValues = resources.getIdentifier("${days[i].toLowerCase()}_min", "id", packageName)
        val maxValues = resources.getIdentifier("${days[i].toLowerCase()}_max", "id", packageName)
        val conditionWeather = resources.getIdentifier("${days[i].toLowerCase()}_condition", "id", packageName)

        val morningText = findViewById <EditText>(minValues).text.toString()
        val afternoonText = findViewById<EditText>(maxValues).text.toString()
        val noteText = findViewById<EditText>(conditionWeather).text.toString()

        if (morningText.isEmpty() || afternoonText.isEmpty() || !morningText.isDigitsOnly() || !afternoonText.isDigitsOnly()) {
            Toast.makeText(this, "input temperature ", Toast.LENGTH_LONG).show()
            return false
        }

        min [i] = morningText.toInt()
        max[i] = afternoonText.toInt()
        condition[i] = noteText
    }
    return true
}

private fun clearInputs() {
    for (i in days.indices) {
        val morningId = resources.getIdentifier("${days[i].toLowerCase()}_morning", "id", packageName)
        val afternoonId = resources.getIdentifier("${days[i].toLowerCase()}_afternoon", "id", packageName)
        val noteId = resources.getIdentifier("${days[i].toLowerCase()}_note", "id", packageName)

        findViewById<EditText>(morningId).text.clear()
        findViewById<EditText>(afternoonId).text.clear()
        findViewById<EditText>(noteId).text.clear()
    }

}
}