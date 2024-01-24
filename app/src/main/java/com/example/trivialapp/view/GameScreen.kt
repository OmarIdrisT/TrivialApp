package com.example.trivialapp.view

import android.os.Handler
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
import androidx.compose.material3.OutlinedButton
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
import com.example.trivialapp.viewmodel.questionariEasy

@Composable
fun GameScreen(navController: NavController, myViewModel: MyViewModel) {
    var trivial by remember {mutableStateOf(mutableListOf<PreguntasYRespuestas.quiz>())  }
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
                    var colorResposta by remember { mutableStateOf(Color.Transparent) }
                    OutlinedButton(
                        onClick = {
                            val handler = Handler()
                            if (respuesta == seleccioQuiz.correctAnswer) {
                                colorResposta = Color.Green
                                score++
                            } else {
                                colorResposta = Color.Red
                            }
                            if (numeroRonda < myViewModel.quantitatRondes) {
                                trivial = trivial.toMutableList()
                                handler.postDelayed({
                                    numeroRonda++
                                    colorResposta = Color.Transparent
                                }, 500)
                            } else {
                                handler.postDelayed({
                                    navController.navigate(Routes.ResultScreen.route)
                                }, 500)
                            }
                        },
                        modifier = Modifier
                            .fillMaxHeight(0.8f)
                            .fillMaxWidth(0.4f)
                            .weight(0.3f)
                            .border(2.dp, Color.White, shape = RoundedCornerShape(16.dp))
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




