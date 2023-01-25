package com.example.practica18_danielcuarental.Coche

import android.graphics.Color

class Coche {
    val numeroBastidor : String
    val marca : String
    val modelo : String
    val color : String
    val combustible : String
    val km : Int

    constructor() {
        numeroBastidor = ""
        marca = ""
        modelo = ""
        color = ""
        combustible = ""
        km = 0
    }

    constructor(numeroBastidor : String, marca : String, modelo: String, color: String, combustible: String, km: Int) {
        this.numeroBastidor = numeroBastidor
        this.marca = marca
        this.modelo = modelo
        this.color = color
        this.combustible = combustible
        this.km = km
    }

    override fun toString(): String {
        return "numeroBastidor=$numeroBastidor (marca='$marca', modelo='$modelo')"
    }




}