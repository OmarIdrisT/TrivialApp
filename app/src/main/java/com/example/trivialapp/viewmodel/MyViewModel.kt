package com.example.trivialapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.trivialapp.R
import com.example.trivialapp.model.PreguntasYRespuestas

class MyViewModel: ViewModel() {

    var dificultatEscollida : String by mutableStateOf("FACIL")
        private set

    fun canviarDificultat (valor : String) {
        dificultatEscollida = valor
    }


    var quantitatRondes: Int by mutableStateOf(10)
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
        fonsPantalla = if(modeFosc) {
            R.drawable.fonsfosc
        }
        else {
            R.drawable.fonsclar
        }
        colorText = if(modeFosc) {
            Color.White
        }
        else {
            Color.Black
        }
    }

    var score : Int by mutableStateOf(0)
        private set

    fun incrementarScore (valor:Int) {
        score = valor
    }

    var fonsPantalla = if(modeFosc) {
        R.drawable.fonsfosc
    }
    else {
        R.drawable.fonsclar
    }

    var colorText = if(modeFosc) {
        Color.White
    }
    else {
        Color.Black
    }

}

val questionariEasy = mutableListOf(
    PreguntasYRespuestas.quiz(
        "¿Cuál fue el detonante de la Primera Guerra Mundial?",
        mutableListOf(
            "El asesinato del archiduque Francisco Fernando de Habsburgo.",
            "La firma del Tratado de Versalles.",
            "El hundimiento del Titanic.",
            "La Revolución Rusa."),
        "El asesinato del archiduque Francisco Fernando de Habsburgo.",
        R.drawable.oceano
    ),
    PreguntasYRespuestas.quiz(
        "¿Quién fue el primer presidente de Estados Unidos?",
        mutableListOf(
            "George Washington.",
            "Abraham Lincoln.",
            "Thomas Jefferson.",
            "Benjamin Franklin."),
        "George Washington.",
        R.drawable.oceano
    ),
    PreguntasYRespuestas.quiz(
        "¿En qué año se disolvió la Unión Soviética?",
        mutableListOf(
            "1989.",
            "1991.",
            "1993.",
            "1995."),
        "1991.",
        R.drawable.oceano
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es el idioma más hablado en Suiza?",
        mutableListOf(
            "Alemán.",
            "Francés.",
            "Italiano.",
            "Rumano."),
        "Alemán.",
        R.drawable.oceano
    ),
    PreguntasYRespuestas.quiz(
        "¿En qué disciplina deportiva juega Leo Messi?",
        mutableListOf("Fútbol.",
            "Tenis.",
            "Baloncesto.",
            "Golf."),
        "Fútbol.",
        R.drawable.oceano
    ),
    PreguntasYRespuestas.quiz(
        "¿Dónde se encuentra la Torre de Pisa?",
        mutableListOf(
            "Roma, Italia.",
            "Florencia, Italia.",
            "Venecia, Italia.",
            "Pisa, Italia."),
        "Pisa, Italia.",
        R.drawable.oceano
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es el océano más grande del mundo?",
        mutableListOf(
            "Océano Atlántico.",
            "Océano Índico.",
            "Océano Pacífico.",
            "Océano Ártico."),

        "Océano Pacífico.",
        R.drawable.oceano
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es la capital de Indonesia?",
        mutableListOf(
            "Yakarta.",
            "Bangkok.",
            "Kuala Lumpur.",
            "Manila."),
        "Yakarta.",
        R.drawable.oceano
    ),
    PreguntasYRespuestas.quiz(
        "¿Quiénes son los protagonistas de la película 'Pretty Woman'?",
        mutableListOf(
            "Julia Roberts y Richard Gere.",
            "Sandra Bullock y Tom Hanks.",
            "Jennifer Aniston y Brad Pitt.",
            "Angelina Jolie y Johnny Depp."),
        "Julia Roberts y Richard Gere.",
        R.drawable.oceano
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es el río más largo de Europa Occidental?",
        mutableListOf(
            "Río Támesis.",
            "Río Rin.",
            "Río Sena.",
            "Río Danubio."),
        "Río Rin.",
        R.drawable.oceano
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es la capital de Francia?",
        mutableListOf(
            "París",
            "Londres",
            "Madrid",
            "Berlín"),
        "París",
        R.drawable.oceano
    ),
    PreguntasYRespuestas.quiz(
        "¿En qué año comenzó la Segunda Guerra Mundial?",
        mutableListOf(
            "1914",
            "1939",
            "1945",
            "1941"),
        "1939",
        R.drawable.oceano
    ),
    PreguntasYRespuestas.quiz(
        "¿Quién escribió la obra de Romeo y Julieta?",
        mutableListOf(
            "William Shakespeare",
            "Miguel de Cervantes",
            "Charles Dickens",
            "Jane Austen"),
        "William Shakespeare",
        R.drawable.oceano
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es el océano más grande del mundo?",
        mutableListOf(
            "Océano Atlántico",
            "Océano Índico",
            "Océano Pacífico",
            "Océano Ártico"),
        "Océano Pacífico",
        R.drawable.oceano
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es el país más grande del mundo por área?",
        mutableListOf(
            "Rusia",
            "Canadá",
            "Estados Unidos",
            "China"),
        "Rusia",
        R.drawable.oceano
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es el animal terrestre más grande?",
        mutableListOf(
            "Elefante africano",
            "Jirafa",
            "Rinoceronte blanco",
            "Hipopótamo"),
        "Elefante africano",
        R.drawable.oceano
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es la montaña más alta del mundo?",
        mutableListOf(
            "Monte Everest",
            "Monte Kilimanjaro",
            "Monte McKinley",
            "Monte Aconcagua"),
        "Monte Everest",
        R.drawable.oceano
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es el idioma más hablado en el mundo?",
        mutableListOf(
            "Inglés",
            "Chino mandarín",
            "Español",
            "Hindi"),
        "Chino mandarín",
        R.drawable.oceano
    ),
    PreguntasYRespuestas.quiz(
        "¿En qué país se encuentra la Torre Eiffel?",
        mutableListOf(
            "España",
            "Italia",
            "Francia",
            "Alemania"),
        "Francia",
        R.drawable.oceano
    ),
    PreguntasYRespuestas.quiz(
        "¿Quién pintó La Mona Lisa?",
        mutableListOf(
            "Vincent van Gogh",
            "Leonardo da Vinci",
            "Pablo Picasso",
            "Michelangelo"),
        "Leonardo da Vinci",
        R.drawable.oceano
    )
)
