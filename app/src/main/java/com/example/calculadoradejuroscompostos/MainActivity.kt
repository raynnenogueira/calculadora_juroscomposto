package com.example.calculadoradejuroscompostos

import android.os.Build.VERSION_CODES.P
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    val valorInicial = findViewById<EditText>(R.id.editValorInicial)
    val taxaJuros = findViewById<EditText>(R.id.editJuros)
    val periodo = findViewById<EditText>(R.id.editPeriodo)
    val btn = findViewById<Button>(R.id.button)
    val total = findViewById<TextView>(R.id.editTotal)


    btn.setOnClickListener {
        val valorInicialText = valorInicial.text.toString()
        val taxaJurosText = taxaJuros.text.toString()
        val periodoText = periodo.text.toString()

        if (valorInicialText.isNotEmpty() && taxaJurosText.isNotEmpty() && periodoText.isNotEmpty()) {
            val valorInicial = valorInicialText.toDouble()
            val taxaJuros = taxaJurosText.toDouble()/100
            val periodo = periodoText.toDouble()/12

            val resultado = valorInicial * (1 + taxaJuros).pow(periodo)

            val formatoBR = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
            val totalFormatted = formatoBR.format(resultado)

            total.text = totalFormatted
        }
    }
    }
}