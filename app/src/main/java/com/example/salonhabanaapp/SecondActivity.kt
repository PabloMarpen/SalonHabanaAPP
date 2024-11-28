package com.example.salonhabanaapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.SeekBar
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var spinnerEvento: Spinner
    lateinit var spinnerFecha: Spinner
    lateinit var spinnerCocina: Spinner
    lateinit var tipoEvento : String
    lateinit var fecha : String
    lateinit var tipoCocina : String
    lateinit var personas : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        spinnerEvento = findViewById(R.id.spinnerTipoEvento)
        spinnerFecha = findViewById(R.id.spinnerFecha)
        spinnerCocina = findViewById(R.id.spinnerTipoCocina)
        personas = findViewById(R.id.textPersonas)
        val seekBar = findViewById<SeekBar>(R.id.seekBarDias)
        val SiguienteButtonVista2 = findViewById<Button>(R.id.SiguienteButton2)
        seekBar.min = 0
        seekBar.max = 100
        personas.text = "0"

        ArrayAdapter.createFromResource(
            this,
            R.array.event_types_array,
            R.layout.spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerEvento.adapter = adapter
        }

        ArrayAdapter.createFromResource(
            this,
            R.array.dates_array,
            R.layout.spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerFecha.adapter = adapter
        }

        ArrayAdapter.createFromResource(
            this,
            R.array.tipo_cocina,
            R.layout.spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerCocina.adapter = adapter
        }


        spinnerEvento.onItemSelectedListener = this
        spinnerFecha.onItemSelectedListener = this
        spinnerCocina.onItemSelectedListener = this

        spinnerEvento.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val seleccionado = parent?.getItemAtPosition(position).toString()
                tipoEvento = seleccionado
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerCocina.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val seleccionado = parent?.getItemAtPosition(position).toString()
                tipoCocina = seleccionado
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spinnerFecha.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val seleccionado = parent?.getItemAtPosition(position).toString()
                fecha = seleccionado
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }


        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            /**
             * Método que se llama cada vez que cambio el progreso
             * seekBar contiene la referencia a la seekBar
             * progress contiene el valor actual de la seekbar
             * fromUser indica si el cambio lo ha producido el usuario al arastar la barra
             */
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                personas.text = "$progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })



        SiguienteButtonVista2.setOnClickListener {
            if (tipoEvento.isNullOrEmpty() || comprobarCampos() == false) {
                Toast.makeText(this, "Use todos los campos", Toast.LENGTH_SHORT).show()
            } else if (tipoEvento == "Congreso" && comprobarCampos() == true) {
                val intent = Intent(this, ThreeActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, FinalActivity::class.java)
                startActivity(intent)
            }
        }



    }

    fun comprobarCampos(): Boolean {

        if (tipoEvento.isNullOrEmpty() || tipoCocina.isNullOrEmpty() || fecha.isNullOrEmpty() || personas.text.isNullOrEmpty()) {
            return false
        } else {
            return true
        }


    }
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }
}
