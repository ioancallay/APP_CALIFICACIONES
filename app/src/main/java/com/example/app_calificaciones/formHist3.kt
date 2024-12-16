package com.example.app_calificaciones

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class formHist3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_form_hist3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var chk1 = findViewById<CheckBox>(R.id.chk_his31)
        var chk2 = findViewById<CheckBox>(R.id.chk_his32)
        var chk3 = findViewById<CheckBox>(R.id.chk_his33)
        val nombre = intent.getStringExtra("nombre")
        var puntosActuales = intent.getIntExtra("puntosActual", 0)

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

        val puntosTotal = puntos
        val btnSiguiente = findViewById<Button>(R.id.btn_his3)
        btnSiguiente.setOnClickListener {
            val res_his3 = Intent(this, formHist4::class.java)
            res_his3.putExtra("nombre", nombre)
            res_his3.putExtra("puntos", puntosTotal)
            startActivity(res_his3)
        }
    }
}