package com.example.app_calificaciones

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class resIng : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_res_ing)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val puntosActuales = intent.getIntExtra("puntosActuales", 0)
        val nombre = intent.getStringExtra("nombre")

        val lblNombre = findViewById<TextView>(R.id.lbl_ingnombre)
        val lblRespuesta = findViewById<TextView>(R.id.lbl_ingresp)

        lblNombre.text = nombre + " tus resultados"
        lblRespuesta.text = "Puntos obtenidos " + puntosActuales.toString() + "\nMalas\nBuenas"
        val btnRegresar = findViewById<Button>(R.id.btn_ingregresar)

        btnRegresar.setOnClickListener {
            val opciones = Intent(this, Activity_Options::class.java)
            opciones.putExtra("nombre", nombre)
            opciones.putExtra("puntosTotal", puntosActuales)
            startActivity(opciones)
        }
    }
}