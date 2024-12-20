package com.example.app_calificaciones

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class formIng1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_form_ing1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var puntos = 0
        val nombre = intent.getStringExtra("nombre")
        val rgRespuesta =findViewById<RadioGroup>(R.id.rgRespuesta1) as RadioGroup
        rgRespuesta.setOnCheckedChangeListener { radioGroup, i ->
            puntos = when(i){
                R.id.rgTrue1 -> 1
                R.id.rgFalse1 -> 0
                else -> 0
            }
        }

        val btnSiguiente = findViewById<Button>(R.id.btn_ing1)
        btnSiguiente.setOnClickListener {
            val resp = Intent(this, formIng2::class.java)
            resp.putExtra("nombre", nombre)
            resp.putExtra("puntosActuales", puntos)
            startActivity(resp)
        }
    }
}