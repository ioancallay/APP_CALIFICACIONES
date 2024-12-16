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

class formMat1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_form_mat1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var mensaje = findViewById<TextView>(R.id.lbl_mensaje1)

        val chk1 = findViewById<CheckBox>(R.id.chk_mat11)
        val chk2 = findViewById<CheckBox>(R.id.chk_mat12)
        val chk3 = findViewById<CheckBox>(R.id.chk_mat13)
        val nombre = intent.getStringExtra("nombre")
        mensaje.text = "1. " + nombre
        val puntos = when {
            chk1.isChecked && chk2.isChecked && chk3.isChecked -> 0
            chk1.isChecked && chk2.isChecked -> 2
            chk1.isChecked && chk3.isChecked -> 1
            chk2.isChecked && chk3.isChecked -> 1
            else -> 0
        }

        val btnSiguiente = findViewById<Button>(R.id.btn_mat11)

        btnSiguiente.setOnClickListener {
            val mat_res1 = Intent(this, formMat2::class.java)
            mat_res1.putExtra("puntos", puntos)
            mat_res1.putExtra("nombre", nombre)
            startActivity(mat_res1)
        }
    }
}