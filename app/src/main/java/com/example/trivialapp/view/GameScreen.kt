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


@Composable
fun GameScreen(navController: NavController, myViewModel: MyViewModel) {
    var trivial : PreguntasYRespuestas.quiz
    when(myViewModel.dificultatEscollida) {
        "FACIL" -> trivial = questionariEasy.random()
        "NORMAL" -> trivial = questionariEasy.random()
        else -> trivial = questionariEasy.random()
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
        Text(text = missatgeRondes)
        Text(text = trivial.question)
        var numeroRespostes = 1
            repeat(2) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(3.dp, Color.White)
                        .fillMaxHeight(0.15f),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    repeat(2) {
                        Box(
                            modifier = Modifier
                                .background(Color.Transparent)
                                .border(2.dp, Color.White, shape = RoundedCornerShape(16.dp))
                                .fillMaxHeight(0.8f)
                                .fillMaxWidth(0.4f)
                                .weight(0.3f)
                                .clickable {
                                    numeroRonda++
                                }

                        ) {
                            Text(trivial.answer1)
                        }
                    }
                }
            }
    }
    if (numeroRonda == myViewModel.quantitatRondes + 1) {
            missatgeRondes = "Ronda ${myViewModel.quantitatRondes}/${myViewModel.quantitatRondes}"
            navController.navigate(Routes.ResultScreen.route)
    }
}


val questionariEasy = arrayOf(
    PreguntasYRespuestas.quiz(
        "¿Cuál fue el detonante de la Primera Guerra Mundial?",
        "El asesinato del archiduque Francisco Fernando de Habsburgo.",
        "La firma del Tratado de Versalles.",
        "El hundimiento del Titanic.",
        "La Revolución Rusa.",
        "El asesinato del archiduque Francisco Fernando de Habsburgo."
    ),
    PreguntasYRespuestas.quiz(
        "¿Quién fue el primer presidente de Estados Unidos?",
        "George Washington.",
        "Abraham Lincoln.",
        "Thomas Jefferson.",
        "Benjamin Franklin.",
        "George Washington."
    ),
    PreguntasYRespuestas.quiz(
        "¿En qué año se disolvió la Unión Soviética?",
        "1989.",
        "1991.",
        "1993.",
        "1995.",
        "1991."
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es el idioma más hablado en Suiza?",
        "Alemán.",
        "Francés.",
        "Italiano.",
        "Rumano.",
        "Alemán."
    ),
    PreguntasYRespuestas.quiz(
        "¿En qué disciplina deportiva juega Leo Messi?",
        "Fútbol.",
        "Tenis.",
        "Baloncesto.",
        "Golf.",
        "Fútbol."
    ),
    PreguntasYRespuestas.quiz(
        "¿Dónde se encuentra la Torre de Pisa?",
        "Roma, Italia.",
        "Florencia, Italia.",
        "Venecia, Italia.",
        "Pisa, Italia.",
        "Pisa, Italia."
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es el océano más grande del mundo?",
        "Océano Atlántico.",
        "Océano Índico.",
        "Océano Pacífico.",
        "Océano Ártico.",
        "Océano Pacífico."
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es la capital de Indonesia?",
        "Yakarta.",
        "Bangkok.",
        "Kuala Lumpur.",
        "Manila.",
        "Yakarta."
    ),
    PreguntasYRespuestas.quiz(
        "¿Quiénes son los protagonistas de la película 'Pretty Woman'?",
        "Julia Roberts y Richard Gere.",
        "Sandra Bullock y Tom Hanks.",
        "Jennifer Aniston y Brad Pitt.",
        "Angelina Jolie y Johnny Depp.",
        "Julia Roberts y Richard Gere."
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es el río más largo de Europa Occidental?",
        "Río Támesis.",
        "Río Rin.",
        "Río Sena.",
        "Río Danubio.",
        "Río Rin."
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es la capital de Francia?",
        "París",
        "Londres",
        "Madrid",
        "Berlín",
        "París"
    ),
    PreguntasYRespuestas.quiz(
        "¿En qué año comenzó la Segunda Guerra Mundial?",
        "1914",
        "1939",
        "1945",
        "1941",
        "1939"
    ),
    PreguntasYRespuestas.quiz(
        "¿Quién escribió la obra de Romeo y Julieta?",
        "William Shakespeare",
        "Miguel de Cervantes",
        "Charles Dickens",
        "Jane Austen",
        "William Shakespeare"
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es el océano más grande del mundo?",
        "Océano Atlántico",
        "Océano Índico",
        "Océano Pacífico", "Océano Ártico",
        "Océano Pacífico"
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es el país más grande del mundo por área?",
        "Rusia",
        "Canadá",
        "Estados Unidos",
        "China",
        "Rusia"
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es el animal terrestre más grande?",
        "Elefante africano",
        "Jirafa",
        "Rinoceronte blanco",
        "Hipopótamo",
        "Elefante africano"
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es la montaña más alta del mundo?",
        "Monte Everest",
        "Monte Kilimanjaro",
        "Monte McKinley",
        "Monte Aconcagua",
        "Monte Everest"
    ),
    PreguntasYRespuestas.quiz(
        "¿Cuál es el idioma más hablado en el mundo?",
        "Inglés",
        "Chino mandarín",
        "Español",
        "Hindi",
        "Chino mandarín"
    ),
    PreguntasYRespuestas.quiz(
        "¿En qué país se encuentra la Torre Eiffel?",
        "España",
        "Italia",
        "Francia",
        "Alemania",
        "Francia"
    ),
    PreguntasYRespuestas.quiz(
        "¿Quién pintó La Mona Lisa?",
        "Vincent van Gogh",
        "Leonardo da Vinci",
        "Pablo Picasso",
        "Michelangelo",
        "Leonardo da Vinci"
    )
)