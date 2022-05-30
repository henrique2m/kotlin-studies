package com.example.prizedraw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun play(view: View) {
        var resultText: TextView = findViewById(R.id.resultText)
        var numberSort = Random().nextInt(11)

        resultText.text = "O número soteado é: " + numberSort;
    }

}