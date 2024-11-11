package com.example.salonhabanaapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        class SecondActivity : AppCompatActivity() {
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                enableEdgeToEdge()
                setContentView(R.layout.activity_second)

                val spinnerFecha = findViewById<Spinner>(R.id.spinnerFecha)
                val spinnerTipoEvento = findViewById<Spinner>(R.id.spinnerTipoEvento)

                val adapterFecha = ArrayAdapter.createFromResource(
                    this,
                    R.array.dates_array,
                    android.R.layout.simple_spinner_item
                )
                adapterFecha.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerFecha.adapter = adapterFecha

                val adapterTipoEvento = ArrayAdapter.createFromResource(
                    this,
                    R.array.event_types_array,
                    android.R.layout.simple_spinner_item
                )
                adapterTipoEvento.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerTipoEvento.adapter = adapterTipoEvento
            }
        }


    }
}