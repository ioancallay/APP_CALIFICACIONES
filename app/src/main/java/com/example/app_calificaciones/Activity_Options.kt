package com.example.app_calificaciones

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity_Options : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_options)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nombre = intent.getStringExtra("nombre")
        val lblNombreOpciones = findViewById<TextView>(R.id.lbl_nombreOpc)
        lblNombreOpciones.text = "Bienvenido " + nombre

        val btnMatematicas = findViewById<Button>(R.id.btn_matematicas)
        val btnIngles = findViewById<Button>(R.id.btn_ingles)
        val btnInformatica = findViewById<Button>(R.id.btn_informatica)
        val btnHistoria = findViewById<Button>(R.id.btn_historia)
        val btnMoviles = findViewById<Button>(R.id.btn_moviles)
        val btnResultado = findViewById<Button>(R.id.btn_resultado)

        btnMatematicas.setOnClickListener {
            val mat1 = Intent(this, formMat1::class.java)
            mat1.putExtra("nombre", nombre)
            startActivity(mat1)
        }
    }
}