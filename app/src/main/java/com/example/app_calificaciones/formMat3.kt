package com.example.app_calificaciones

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class formMat3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_form_mat3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var chk1 = findViewById<CheckBox>(R.id.chk_mat31)
        var chk2 = findViewById<CheckBox>(R.id.chk_mat32)
        var chk3 = findViewById<CheckBox>(R.id.chk_mat33)
        val nombre = intent.getStringExtra("nombre")

        var puntos = 0
        if(chk1.isChecked && chk2.isChecked && chk3.isChecked){
            puntos = 0
        }
        if(chk1.isChecked && chk2.isChecked){
            puntos = 2
        }
        if(chk1.isChecked && chk3.isChecked){
            puntos = 1
        }
        if(chk2.isChecked && chk3.isChecked){
            puntos = 1
        }

        var puntosActuales = intent.getIntExtra("puntosActual", 0)
        val puntosTotal = puntos + puntosActuales
        val btnSiguiente = findViewById<Button>(R.id.btn_mat31)
        btnSiguiente.setOnClickListener {
            val res_mat3 = Intent(this, formMat4::class.java)
            res_mat3.putExtra("nombre", nombre)
            res_mat3.putExtra("puntos", puntosTotal)
            startActivity(res_mat3)
        }
    }
}