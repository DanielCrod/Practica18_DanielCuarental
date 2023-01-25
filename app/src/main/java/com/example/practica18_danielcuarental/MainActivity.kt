package com.example.practica18_danielcuarental

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Intents.Insert
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.practica18_danielcuarental.Coche.CochesContract
import com.example.practica18_danielcuarental.Fragments.FragmentList
import com.example.practica18_danielcuarental.SQL.SqliteHelper
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var fab : FloatingActionButton

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab = findViewById(R.id.fab)
        fab.setOnClickListener(this)


        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        var miFragmento = FragmentList()
        fragmentTransaction.replace(R.id.frameLayout, miFragmento)
        fragmentTransaction.commit()
    }

    override fun onClick(v: View?) {
        val dialog = DialogInsertar()
        dialog.show(supportFragmentManager, "nuevo")
    }


}