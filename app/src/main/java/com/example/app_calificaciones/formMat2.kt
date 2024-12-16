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

class formMat2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_form_mat2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var chk1 = findViewById<CheckBox>(R.id.chk_mat21)
        var chk2 = findViewById<CheckBox>(R.id.chk_mat22)
        var chk3 = findViewById<CheckBox>(R.id.chk_mat23)
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
        val btnSiguiente = findViewById<Button>(R.id.btn_mat21)
        btnSiguiente.setOnClickListener {
            val res_mat2 = Intent(this, formMat3::class.java)
            res_mat2.putExtra("nombre", nombre)
            res_mat2.putExtra("puntos", puntosTotal)
            startActivity(res_mat2)
        }



    }
}