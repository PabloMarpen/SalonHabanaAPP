package com.example.salonhabanaapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class ThreeActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_three)
        val numeroDias = findViewById<TextView>(R.id.textDias)
        val numeroHabitaciones = findViewById<TextView>(R.id.textHabitaciones)
        val seekbarDias = findViewById<SeekBar>(R.id.seekBarDias)
        val seekbarhabitaciones = findViewById<SeekBar>(R.id.seekBarHabitaciones)
        val SiguienteButtonThree = findViewById<Button>(R.id.SiguienteButtonThree)
        numeroHabitaciones.text = "0"
        numeroDias.text = "0"
        seekbarDias.min = 0
        seekbarDias.max = 30
        seekbarhabitaciones.min = 0
        seekbarhabitaciones.max = 100

        seekbarDias.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                numeroDias.text = "$progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        seekbarhabitaciones.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                numeroHabitaciones.text = "$progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        SiguienteButtonThree.setOnClickListener(){
            if (numeroHabitaciones.text == "0" || numeroDias.text == "0"){
                Toast.makeText(this, "Use todos los campos", Toast.LENGTH_SHORT).show()
            }else {
                val intent = Intent(this, FinalActivity::class.java)
                startActivity(intent)
            }
        }

    }
}