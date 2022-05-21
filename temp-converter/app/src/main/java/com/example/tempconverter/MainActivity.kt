package com.example.tempconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton

class MainActivity : AppCompatActivity() {
    lateinit var valueTemp: EditText
    lateinit var celsiusRadio: RadioButton
    lateinit var fahrenheitRadio: RadioButton
    lateinit var buttonConvertTemperature: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        valueTemp = findViewById<EditText>(R.id.valueTamp)
        celsiusRadio = findViewById<RadioButton>(R.id.celsiusRadio)
        fahrenheitRadio = findViewById<RadioButton>(R.id.fahrenheitRadio)
        buttonConvertTemperature = findViewById<Button>(R.id.buttonConvertTemperature)

        buttonConvertTemperature.setOnClickListener { converter(it) }
    }

    private fun converter(view: View) {
        var temp: Double = valueTemp.text.toString().toDouble()

        temp = if (celsiusRadio.isChecked) {
            (temp - 32) * 5 / 9
        } else {
            temp * 9 / 5 + 32
        }

        valueTemp.setText(temp.toString())
    }
}