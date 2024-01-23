package com.example.trivialapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.trivialapp.R
import com.example.trivialapp.model.PreguntasYRespuestas
import com.example.trivialapp.navigation.Routes
import com.example.trivialapp.viewmodel.MyViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun GameScreen(navController: NavController, myViewModel: MyViewModel) {
    var trivial: MutableList<PreguntasYRespuestas.quiz>
    var score by remember { mutableStateOf(0) }

    when(myViewModel.dificultatEscollida) {
        "FACIL" -> trivial = questionariEasy
        "NORMAL" -> trivial = questionariEasy
        else -> trivial = questionariEasy
    }
    var numeroRonda by remember { mutableStateOf(1) }
    var missatgeRondes = "Ronda $numeroRonda/${myViewModel.quantitatRondes}"
    Image(
        painter = painterResource(id = R.drawable.fondo),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val seleccioQuiz = trivial.random()
        val preguntaQuiz = seleccioQuiz.question
        Text(text = missatgeRondes)
        Text(text = preguntaQuiz)
        repeat(2) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(3.dp, Color.White)
                    .fillMaxHeight(0.15f),
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                repeat(2) {
                    val respuesta = seleccioQuiz.answers.random()
                    var colorResposta = Color.Transparent
                    Box(
                        modifier = Modifier
                            .background(colorResposta)
                            .border(2.dp, Color.White, shape = RoundedCornerShape(16.dp))
                            .fillMaxHeight(0.8f)
                            .fillMaxWidth(0.4f)
                            .weight(0.3f)
                            .clickable {
                                if (numeroRonda < myViewModel.quantitatRondes) {
                                    if (respuesta == seleccioQuiz.correctAnswer) {
                                        colorResposta = Color.Green
                                        score++

                                    }
                                    else {
                                        colorResposta = Color.Red
                                    }
                                    numeroRonda++
                                }
                                else {
                                    navController.navigate(Routes.ResultScreen.route)
                                }
                            }

                    ) {
                        Text(respuesta)
                        seleccioQuiz.answers.remove(respuesta)
                    }
                }
            }
        }
        trivial.remove(seleccioQuiz)
        Text("Score: $score")
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

