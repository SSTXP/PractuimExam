package com.example.practuimexam

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {


    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val returnButton : Button = findViewById(R.id.returnButton)
        returnButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }


        val min = intent.getIntArrayExtra("min") ?: return
        val max = intent.getIntArrayExtra("max") ?: return
        val condition = intent.getStringArrayExtra("condition") ?: return


        var layoutTable: TableLayout = findViewById(R.id.layoutTable)

        var avgtemp = 0
        for (i in min.indices) {
            val row = TableRow(this)
            row.addView(createTextView(days[i]))
            row.addView(createTextView(min[i].toString()))
            row.addView(createTextView(max[i].toString()))
            row.addView(createTextView(condition[i]))

            layoutTable.addView(row)

            avgtemp += min[i] + max[i] / 2
            //to get average temperature add min and max values then divide by 2
        }

        val avgTemp: TextView = findViewById(R.id.avgTemp)
        avgTemp.text = "average temp: $avgtemp"

    }

    private fun createTextView(text: String): TextView {
        val textView = TextView(this)
        textView.text = text
        return textView
    }

    companion object {
        private val days = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    }
}