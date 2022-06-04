package com.example.gasoline_or_alcohol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textResult = findViewById(R.id.tv_result);
    }

    fun calculatePrice(view: View) {
        val priceGasoline = findViewById<EditText>(R.id.et_gasoline).text.toString()
        val priceAlcohol = findViewById<EditText>(R.id.et_alcohol).text.toString()

        if (inputsValidates(priceGasoline, priceAlcohol)) {
            this.bestPriceCalculate(priceGasoline, priceAlcohol)
        } else {
            textResult.text = "Por favor! Preencha todos os campos."
        }
    }

    private fun inputsValidates(priceGasoline: String, priceAlcohol: String): Boolean {
        var isValid: Boolean = true;

        if (priceAlcohol == "") {
            isValid = false;
        } else if (priceGasoline == "") {
            isValid = false;
        }

        return isValid;
    }


    private fun bestPriceCalculate(priceGasoline: String, priceAlcohol: String) {
        val valueAlcohol = priceAlcohol.toDouble()
        val valueGasoline = priceGasoline.toDouble()

        val priceResult = valueAlcohol / valueGasoline

        if (priceResult >= 0.7) {
            textResult.text = "Melhor utilizar Gasolina!"
        } else {
            textResult.text = "Melhor utilizar Álcool!"
        }
    }
}