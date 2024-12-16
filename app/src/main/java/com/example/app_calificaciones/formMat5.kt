package com.example.app_calificaciones

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class formMat5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_form_mat5)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val chk1 = findViewById<CheckBox>(R.id.chk_mat51)
        val chk2 = findViewById<CheckBox>(R.id.chk_mat52)
        val chk3 = findViewById<CheckBox>(R.id.chk_mat53)
        val nombre = intent.getStringExtra("nombre")
        val puntosActuales = intent.getIntExtra("puntos", 0)

        var mensaje = findViewById<TextView>(R.id.lbl_mat5)
        mensaje.text = nombre + " Puntos " + puntosActuales

        val puntos = when {
            chk1.isChecked && chk2.isChecked && chk3.isChecked -> 0
            chk1.isChecked && chk2.isChecked -> 2
            chk1.isChecked && chk3.isChecked -> 1
            chk2.isChecked && chk3.isChecked -> 1
            else -> 0
        }

        val puntosTotal = puntosActuales + puntos
        val btnSiguiente = findViewById<Button>(R.id.btn_mat51)
        btnSiguiente.setOnClickListener {
            val res_mat5 = Intent(this, resMat::class.java)
            res_mat5.putExtra("nombre", nombre)
            res_mat5.putExtra("puntos", puntosTotal)
            startActivity(res_mat5)
        }
    }
}