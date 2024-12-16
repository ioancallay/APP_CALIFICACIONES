package com.example.app_calificaciones

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class formHist1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_form_hist1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var chk1 = findViewById<CheckBox>(R.id.chk_his11)
        var chk2 = findViewById<CheckBox>(R.id.chk_his12)
        var chk3 = findViewById<CheckBox>(R.id.chk_his13)
        val nombre = intent.getStringExtra("nombre")

        var puntos = 0
        if(chk1.isChecked && chk2.isChecked && chk3.isChecked){
            puntos = -1
        }
        else if(chk1.isChecked && chk2.isChecked){
            puntos = 2
        }
        else if(chk1.isChecked && chk3.isChecked){
            puntos = 1
        }
        else if(chk2.isChecked && chk3.isChecked){
            puntos = 1
        }

        else{
            puntos = 0
        }

        val btnSiguiente = findViewById<Button>(R.id.btn_his1)

        btnSiguiente.setOnClickListener {
            val his_res1 = Intent(this, formHist1::class.java)
            his_res1.putExtra("puntosActual", puntos)
            his_res1.putExtra("nombre", nombre)

            startActivity(his_res1)
        }
    }
}