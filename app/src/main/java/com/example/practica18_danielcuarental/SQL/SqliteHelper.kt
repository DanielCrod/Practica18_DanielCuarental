package com.example.practica18_danielcuarental.SQL

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build.VERSION
import com.example.practica18_danielcuarental.Coche.Coche
import com.example.practica18_danielcuarental.Coche.CochesContract

class SqliteHelper(context: Context):
    SQLiteOpenHelper(context, NAME, null, VERSION){

        companion object {
            private const val NAME = "concesionario.db"
            private const val VERSION = 1
        }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            "CREATE TABLE " +
                    CochesContract.TABLE_NAME + " ( "
                    + " _id INTEGER PRIMARY KEY AutoIncrement NOT NULL, "
                    + CochesContract.NUMEROBASTIDOR + " TEXT, "
                    + CochesContract.MARCA + " TEXT, "
                    + CochesContract.MODELO + " TEXT, "
                    + CochesContract.COLOR + " TEXT, "
                    + CochesContract.COMBUSTIBLE + " TEXT, "
                    + CochesContract.KM + " INTEGER);"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insertar(coche: Coche):Long {
        val db = writableDatabase
        val values = ContentValues()
        values.put(CochesContract.NUMEROBASTIDOR, coche.numeroBastidor)
        values.put(CochesContract.MARCA, coche.marca)
        values.put(CochesContract.MODELO, coche.modelo)
        values.put(CochesContract.COMBUSTIBLE, coche.combustible)
        values.put(CochesContract.COLOR, coche.color)
        values.put(CochesContract.KM, coche.km)

        return db.insert(CochesContract.TABLE_NAME, null, values)
    }

    fun leerDatos (): android.database.Cursor {
        val db = writableDatabase
        var datos : android.database.Cursor =
            db.rawQuery("SELECT nBastidor, marca, modelo FROM " + CochesContract.TABLE_NAME + "", null)
        return datos
    }


}