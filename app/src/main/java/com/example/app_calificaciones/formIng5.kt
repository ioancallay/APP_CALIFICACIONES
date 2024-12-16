package com.example.app_calificaciones

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class formIng5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_form_ing5)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var puntos = 0
        val nombre = intent.getStringExtra("nombre")
        val rgRespuesta =findViewById<RadioGroup>(R.id.rgRespuesta5) as RadioGroup
        rgRespuesta.setOnCheckedChangeListener { radioGroup, i ->
            puntos = when(i){
                R.id.rgTrue5 -> 1
                R.id.rgFalse5 -> 0
                else -> 0
            }
        }

        var puntosActuales = intent.getIntExtra("puntosActual", 0)
        var puntosTotal = puntos + puntosActuales
        val btnSiguiente = findViewById<Button>(R.id.btn_ing5)
        btnSiguiente.setOnClickListener {
            val resp = Intent(this, resIng::class.java)
            resp.putExtra("nombre", nombre)
            resp.putExtra("puntosActuales", puntosTotal)
            startActivity(resp)
        }
    }
}