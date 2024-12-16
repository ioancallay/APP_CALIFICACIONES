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

        val chk1 = findViewById<CheckBox>(R.id.chk_mat21)
        val chk2 = findViewById<CheckBox>(R.id.chk_mat22)
        val chk3 = findViewById<CheckBox>(R.id.chk_mat23)
        val nombre = intent.getStringExtra("nombre")
        val puntosActuales = intent.getIntExtra("puntos", 0)
        Log.d("DEBUG", "Puntos recibidos: $puntosActuales")

        val mensaje = findViewById<TextView>(R.id.lbl_mat2)
        mensaje.text = nombre + " Puntos " + puntosActuales

        val puntos = when {
            chk1.isChecked && chk2.isChecked && chk3.isChecked -> 0
            chk1.isChecked && chk2.isChecked -> 2
            chk1.isChecked && chk3.isChecked -> 1
            chk2.isChecked && chk3.isChecked -> 1
            else -> 0
        }

        val puntosTotal = puntosActuales + puntos
        val btnSiguiente = findViewById<Button>(R.id.btn_mat21)
        btnSiguiente.setOnClickListener {
            val res_mat2 = Intent(this, formMat3::class.java)
            res_mat2.putExtra("nombre", nombre)
            res_mat2.putExtra("puntos", puntosTotal)
            startActivity(res_mat2)
        }



    }
}