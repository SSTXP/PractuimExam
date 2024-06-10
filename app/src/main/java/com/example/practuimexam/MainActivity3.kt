package com.example.practuimexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity3 : AppCompatActivity() {

    val morningTimes = intent.getIntArrayExtra("morningTimes") ?: return
    val afternoonTimes = intent.getIntArrayExtra("afternoonTimes") ?: return
    val notes = intent.getStringArrayExtra("notes") ?: return
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)


    }
}