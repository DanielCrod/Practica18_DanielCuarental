package com.example.practica18_danielcuarental

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.DialogFragment
import com.example.practica18_danielcuarental.Coche.Coche
import com.example.practica18_danielcuarental.SQL.SqliteHelper

class DialogInsertar: DialogFragment() {

    private lateinit var nBastidor : EditText
    private lateinit var marca : EditText
    private lateinit var modelo : EditText
    private lateinit var color : Spinner
    private lateinit var combustible : Spinner
    private lateinit var km : EditText


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(context)


        val inflater = requireActivity().layoutInflater
        val view : View = inflater.inflate(R.layout.dialog, null)

        color = view.findViewById(R.id.color)
        combustible = view.findViewById(R.id.combustible)

        val adaptadorColorSpinner = context?.let {
            ArrayAdapter.createFromResource(
                it, R.array.colores, android.R.layout.simple_dropdown_item_1line)
        }

        val adaptadorCombustibleSpinner = context?.let {
            ArrayAdapter.createFromResource(
                it, R.array.combustibles, android.R.layout.simple_dropdown_item_1line)
        }
        color.adapter = adaptadorColorSpinner
        combustible.adapter = adaptadorCombustibleSpinner



        builder.setMessage("Insertar coche")
        builder.setView(inflater.inflate(R.layout.dialog, null))
            // Add action buttons
            .setPositiveButton("Insertar",
                DialogInterface.OnClickListener { dialog, id ->


                })
            .setNegativeButton("Cancelar",
                DialogInterface.OnClickListener { dialog, id ->
                    getDialog()?.cancel()
                })
        builder.create()





        return builder.create()
    }
}


