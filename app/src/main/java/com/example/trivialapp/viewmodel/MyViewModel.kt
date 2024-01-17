package com.example.trivialapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {

    var dificultatEscollida : String by mutableStateOf("FACIL")
        private set

    fun canviarDificultat (valor : String) {
        dificultatEscollida = valor
    }


    var quantitatRondes: Int by mutableStateOf(5)
        private set

    fun canviarRondes (valor: Int) {
        quantitatRondes = valor
    }

    var tempsPerRonda : Float by mutableStateOf(20f)
        private set

    fun canviarTemps (valor: Float) {
        tempsPerRonda = valor
    }

    var modeFosc : Boolean by mutableStateOf(false)
        private set

    fun canviarMode (valor: Boolean) {
        modeFosc = valor
    }

}

