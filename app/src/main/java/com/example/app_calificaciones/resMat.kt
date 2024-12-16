package com.example.app_calificaciones

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class resMat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_res_mat)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val puntosMat = intent.getIntExtra("puntos", 0)
        val nombre = intent.getStringExtra("nombre")
        val btnRegresar = findViewById<Button>(R.id.btn_matregresar)
        btnRegresar.setOnClickListener {
            val regMat = Intent(this, Activity_Options::class.java)
            regMat.putExtra("nombre", nombre)
            regMat.putExtra("puntosMat", puntosMat)
            startActivity(regMat)
        }
    }
}