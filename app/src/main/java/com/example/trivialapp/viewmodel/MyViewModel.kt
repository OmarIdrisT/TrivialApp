package com.example.trivialapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
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
        "El asesinato del archiduque Francisco Fernando de Habsburgo."
    ),
    PreguntasYRespuestas.quiz(
        "¿Quién fue el primer presidente de Estados Unidos?",
        mutableListOf(
            "George Washington.",
            "Abraham Lincoln.",
            "Thomas Jefferson.",
            "Benjamin Franklin."),
        "George Washington."
    ),
    PreguntasYRespuestas.quiz(
        "¿En qué año se disolvió la Unión Soviética?",
        mutableListOf(
            "1989.",
            "1991.",
            "1993.",
            "1995."),
        "1991."
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es el idioma más hablado en Suiza?",
        mutableListOf(
            "Alemán.",
            "Francés.",
            "Italiano.",
            "Rumano."),
        "Alemán."
    ),
    PreguntasYRespuestas.quiz(
        "¿En qué disciplina deportiva juega Leo Messi?",
        mutableListOf("Fútbol.",
            "Tenis.",
            "Baloncesto.",
            "Golf."),
        "Fútbol."
    ),
    PreguntasYRespuestas.quiz(
        "¿Dónde se encuentra la Torre de Pisa?",
        mutableListOf(
            "Roma, Italia.",
            "Florencia, Italia.",
            "Venecia, Italia.",
            "Pisa, Italia."),
        "Pisa, Italia."
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es el océano más grande del mundo?",
        mutableListOf(
            "Océano Atlántico.",
            "Océano Índico.",
            "Océano Pacífico.",
            "Océano Ártico."),

        "Océano Pacífico."
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es la capital de Indonesia?",
        mutableListOf(
            "Yakarta.",
            "Bangkok.",
            "Kuala Lumpur.",
            "Manila."),
        "Yakarta."
    ),
    PreguntasYRespuestas.quiz(
        "¿Quiénes son los protagonistas de la película 'Pretty Woman'?",
        mutableListOf(
            "Julia Roberts y Richard Gere.",
            "Sandra Bullock y Tom Hanks.",
            "Jennifer Aniston y Brad Pitt.",
            "Angelina Jolie y Johnny Depp."),
        "Julia Roberts y Richard Gere."
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es el río más largo de Europa Occidental?",
        mutableListOf(
            "Río Támesis.",
            "Río Rin.",
            "Río Sena.",
            "Río Danubio."),
        "Río Rin."
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es la capital de Francia?",
        mutableListOf(
            "París",
            "Londres",
            "Madrid",
            "Berlín"),
        "París"
    ),
    PreguntasYRespuestas.quiz(
        "¿En qué año comenzó la Segunda Guerra Mundial?",
        mutableListOf(
            "1914",
            "1939",
            "1945",
            "1941"),
        "1939"
    ),
    PreguntasYRespuestas.quiz(
        "¿Quién escribió la obra de Romeo y Julieta?",
        mutableListOf(
            "William Shakespeare",
            "Miguel de Cervantes",
            "Charles Dickens",
            "Jane Austen"),
        "William Shakespeare"
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es el océano más grande del mundo?",
        mutableListOf(
            "Océano Atlántico",
            "Océano Índico",
            "Océano Pacífico",
            "Océano Ártico"),
        "Océano Pacífico"
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es el país más grande del mundo por área?",
        mutableListOf(
            "Rusia",
            "Canadá",
            "Estados Unidos",
            "China"),
        "Rusia"
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es el animal terrestre más grande?",
        mutableListOf(
            "Elefante africano",
            "Jirafa",
            "Rinoceronte blanco",
            "Hipopótamo"),
        "Elefante africano"
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es la montaña más alta del mundo?",
        mutableListOf(
            "Monte Everest",
            "Monte Kilimanjaro",
            "Monte McKinley",
            "Monte Aconcagua"),
        "Monte Everest"
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es el idioma más hablado en el mundo?",
        mutableListOf(
            "Inglés",
            "Chino mandarín",
            "Español",
            "Hindi"),
        "Chino mandarín"
    ),
    PreguntasYRespuestas.quiz(
        "¿En qué país se encuentra la Torre Eiffel?",
        mutableListOf(
            "España",
            "Italia",
            "Francia",
            "Alemania"),
        "Francia",
    ),
    PreguntasYRespuestas.quiz(
        "¿Quién pintó La Mona Lisa?",
        mutableListOf(
            "Vincent van Gogh",
            "Leonardo da Vinci",
            "Pablo Picasso",
            "Michelangelo"),
        "Leonardo da Vinci"
    )
)
