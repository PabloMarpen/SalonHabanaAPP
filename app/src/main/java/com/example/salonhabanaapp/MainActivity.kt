package com.example.salonhabanaapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val SiguienteButtonVista1 = findViewById<Button>(R.id.SiguienteButton1)
        val tlf = findViewById<EditText>(R.id.tlf)
        val nombre = findViewById<EditText>(R.id.nombre)

        SiguienteButtonVista1.setOnClickListener {
            if (tlf.text.toString() == "" || nombre.text.toString() == ""){
                Toast.makeText(this, "Introduce todos los campos porfavor", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
            }
        }




        }
    }
