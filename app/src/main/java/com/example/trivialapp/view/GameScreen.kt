package com.example.trivialapp.view

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trivialapp.R
import com.example.trivialapp.model.PreguntasYRespuestas
import com.example.trivialapp.navigation.Routes
import com.example.trivialapp.viewmodel.MyViewModel
import com.example.trivialapp.viewmodel.questionariDificil
import com.example.trivialapp.viewmodel.questionariFacil
import com.example.trivialapp.viewmodel.questionariNormal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun GameScreen(navController: NavController, myViewModel: MyViewModel) {

    val configuration = LocalConfiguration.current
    var landscape: Boolean
    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            landscape = true
        }

        else -> {
            landscape = false
        }
    }


    var trivial by rememberSaveable { mutableStateOf(mutableListOf<PreguntasYRespuestas.quiz>()) }
    var timeIsRunning by rememberSaveable { mutableStateOf(true) }

    when (myViewModel.dificultatEscollida) {
        "FÁCIL" -> trivial = questionariFacil
        "NORMAL" -> trivial = questionariNormal
        else -> trivial = questionariDificil
    }


    var numeroRonda by rememberSaveable { mutableStateOf(1) }
    var trivialRandom by rememberSaveable { mutableStateOf(trivial.shuffled()) }
    var missatgeRondes = "Ronda $numeroRonda/${myViewModel.quantitatRondes}"
    var seleccioQuiz = trivialRandom[numeroRonda - 1]
    var preguntaQuiz = seleccioQuiz.question
    var respuestas by rememberSaveable { mutableStateOf(seleccioQuiz.answers.shuffled()) }
    var botoClicat by rememberSaveable { mutableStateOf(false) }
    var timeLeft by rememberSaveable { mutableStateOf(myViewModel.tempsPerRonda) }


    Image(
        painter = painterResource(id = myViewModel.fonsPantalla),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
    Column(
        modifier = Modifier
            .fillMaxHeight(0.7f)
            .fillMaxWidth(0.7f),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = missatgeRondes,
            style = TextStyle(
                color = myViewModel.colorText,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.peachcake))
            )
        )
        Text(
            text = preguntaQuiz,
            style = TextStyle(
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.peachcake))
            )
        )
        Image(
            painter = painterResource(id = seleccioQuiz.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .fillMaxHeight(0.3f)
        )
        if (!landscape) {
            repeat(2) { row ->
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    repeat(2) { column ->
                        val index = row * 2 + column
                        val respuesta = respuestas[index]
                        var colorResposta by remember { mutableStateOf(myViewModel.colorText) }
                        var botoEnabled by rememberSaveable { mutableStateOf(true) }
                        botoEnabled = !botoClicat
                        OutlinedButton(
                            onClick = {
                                botoClicat = true
                                timeIsRunning = false
                                if (respuesta == seleccioQuiz.correctAnswer) {
                                    myViewModel.incrementarScore()
                                    colorResposta = Color.Green

                                } else {
                                    colorResposta = Color.Red
                                }

                                CoroutineScope(Dispatchers.Main).launch {
                                    delay(1000)

                                    colorResposta = myViewModel.colorText
                                    if (numeroRonda < myViewModel.quantitatRondes) {
                                        numeroRonda++
                                        seleccioQuiz = trivialRandom[numeroRonda - 1]
                                        preguntaQuiz = seleccioQuiz.question
                                        respuestas = seleccioQuiz.answers.shuffled()
                                        botoClicat = false
                                        timeLeft = myViewModel.tempsPerRonda
                                        timeIsRunning = true

                                    } else {
                                        navController.navigate(Routes.ResultScreen.route)
                                    }

                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.2f)
                                .weight(0.4f),
                            border = BorderStroke(2.dp, colorResposta),
                            enabled = botoEnabled

                        ) {
                            Text(
                                text = respuesta,
                                style = TextStyle(
                                    color = myViewModel.colorText,
                                    fontSize = 20.sp,
                                    textAlign = TextAlign.Center,
                                    fontFamily = FontFamily(Font(R.font.peachcake))
                                )
                            )
                        }
                    }
                }
            }
        }
        else {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(10.dp)
            ) {
                repeat(4) { index ->
                    val respuesta = respuestas[index]
                    var colorResposta by remember { mutableStateOf(myViewModel.colorText) }
                    var botoEnabled by rememberSaveable { mutableStateOf(true) }
                    botoEnabled = !botoClicat
                    OutlinedButton(
                        onClick = {
                            botoClicat = true
                            timeIsRunning = false
                            if (respuesta == seleccioQuiz.correctAnswer) {
                                myViewModel.incrementarScore()
                                colorResposta = Color.Green

                            } else {
                                colorResposta = Color.Red
                            }

                            CoroutineScope(Dispatchers.Main).launch {
                                delay(1000)

                                colorResposta = myViewModel.colorText
                                if (numeroRonda < myViewModel.quantitatRondes) {
                                    numeroRonda++
                                    seleccioQuiz = trivialRandom[numeroRonda - 1]
                                    preguntaQuiz = seleccioQuiz.question
                                    respuestas = seleccioQuiz.answers.shuffled()
                                    botoClicat = false
                                    timeLeft = myViewModel.tempsPerRonda
                                    timeIsRunning = true

                                } else {
                                    navController.navigate(Routes.ResultScreen.route)
                                }

                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.5f)
                            .weight(0.4f)
                            .padding(end = 4.dp),
                        border = BorderStroke(2.dp, colorResposta),
                        enabled = botoEnabled

                    ) {
                        Text(
                            text = respuesta,
                            style = TextStyle(
                                color = myViewModel.colorText,
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center,
                                fontFamily = FontFamily(Font(R.font.peachcake))
                            )
                        )
                    }
                }
            }
        }


        LaunchedEffect(timeLeft) {
            while (timeLeft > 0 && timeIsRunning) {
                delay(100L)
                timeLeft -= 0.1f
            }
            if (!timeIsRunning) {
                timeLeft -= 0
            }
            if (timeLeft.toInt() == 0) {
                if (numeroRonda < myViewModel.quantitatRondes) {
                    numeroRonda++
                    seleccioQuiz = trivialRandom[numeroRonda - 1]
                    preguntaQuiz = seleccioQuiz.question
                    respuestas = seleccioQuiz.answers.shuffled()
                    botoClicat = false
                    timeLeft = myViewModel.tempsPerRonda
                    timeIsRunning = true

                } else {
                    navController.navigate(Routes.ResultScreen.route)
                }
            }
        }

        val colorTimer = if (timeLeft > 2 * myViewModel.tempsPerRonda / 3) {
            Color.Green
        } else if (timeLeft < 2 * myViewModel.tempsPerRonda / 3 && timeLeft > myViewModel.tempsPerRonda / 3) {
            Color.Yellow
        } else {
            Color.Red
        }
        Column(Modifier.fillMaxWidth(0.7f), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Tiempo restante: ${timeLeft.toInt()} s",
                style = TextStyle(
                    color = myViewModel.colorText,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(R.font.peachcake))
                )
            )
            LinearProgressIndicator(
                progress = timeLeft / myViewModel.tempsPerRonda,
                color = colorTimer,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.04f)
            )
        }
    }
}







