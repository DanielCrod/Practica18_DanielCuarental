package com.example.practica18_danielcuarental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.example.practica18_danielcuarental.Coche.Coche
import com.example.practica18_danielcuarental.SQL.SqliteHelper
import java.io.IOException

class InsertarActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var nBastidor : EditText
    private lateinit var marca : EditText
    private lateinit var modelo : EditText
    private lateinit var color : Spinner
    private lateinit var combustible : Spinner
    private lateinit var kilometraje : EditText
    private lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insertar)

        button = findViewById(R.id.insertar)
        nBastidor = findViewById(R.id.nBastidor)
        marca = findViewById(R.id.marca)
        modelo = findViewById(R.id.modelo)
        color = findViewById(R.id.color)
        combustible = findViewById(R.id.combustible)
        kilometraje = findViewById(R.id.km)

        val adaptadorColorSpinner = ArrayAdapter.createFromResource(
            this, R.array.colores, android.R.layout.simple_dropdown_item_1line)

        val adaptadorCombustibleSpinner = ArrayAdapter.createFromResource(
            this, R.array.combustibles, android.R.layout.simple_dropdown_item_1line)

        color.adapter = adaptadorColorSpinner
        combustible.adapter = adaptadorCombustibleSpinner
        button.setOnClickListener(this)




    }

    override fun onClick(v: View?) {
        val helper = SqliteHelper(this)
        try {
            val coche = Coche(nBastidor.text.toString(), marca.text.toString(), modelo.text.toString(), color.toString(), combustible.toString(), kilometraje.text.toString().toInt())
            helper.insertar(coche)
            Toast.makeText(this, "Insertado!", Toast.LENGTH_LONG).show()
        } catch (e : IOException) {
            Toast.makeText(this, "Error al insertar :(", Toast.LENGTH_LONG).show()
        }
    }
}