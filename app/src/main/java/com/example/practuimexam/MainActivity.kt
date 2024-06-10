package com.example.practuimexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.nio.BufferUnderflowException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val exitButton : Button = findViewById(R.id.exitButton)
        val proceedButton : Button = findViewById(R.id.proceedButton)

        exitButton.setOnClickListener {
            finish()
        }

        proceedButton.setOnClickListener {
            //Start the explicit intent
            val intent = Intent(this,MainActivity2 ::class.java)
            //start the activity
            startActivity(intent)
        }
    }
}