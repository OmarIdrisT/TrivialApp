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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trivialapp.R
import com.example.trivialapp.model.PreguntasYRespuestas
import com.example.trivialapp.navigation.Routes
import com.example.trivialapp.viewmodel.MyViewModel
import com.example.trivialapp.viewmodel.questionariEasy

@Composable
fun GameScreen(navController: NavController, myViewModel: MyViewModel) {
    var trivial by remember {mutableStateOf(mutableListOf<PreguntasYRespuestas.quiz>())  }
    var score by remember { mutableStateOf(myViewModel.score) }

    when(myViewModel.dificultatEscollida) {
        "FACIL" -> trivial = questionariEasy
        "NORMAL" -> trivial = questionariEasy
        else -> trivial = questionariEasy
    }

    trivial.shuffled()

    var numeroRonda by remember { mutableStateOf(1) }
    var missatgeRondes = "Ronda $numeroRonda/${myViewModel.quantitatRondes}"
    Image(
        painter = painterResource(id = R.drawable.fondo),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
    Column(
        modifier = Modifier.fillMaxSize(0.5f),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val seleccioQuiz = trivial[numeroRonda - 1]
        val preguntaQuiz = seleccioQuiz.question
        val respuestas = seleccioQuiz.answers.shuffled()

        Text(text = missatgeRondes, style = TextStyle(color = Color.White,fontSize = 20.sp, textAlign = TextAlign.Center, fontFamily = FontFamily(Font(R.font.peachcake))))
        Text(text = preguntaQuiz, style = TextStyle(color = Color.White,fontSize = 20.sp, textAlign = TextAlign.Center, fontFamily = FontFamily(Font(R.font.peachcake))))
        Image(
            painter = painterResource(id = seleccioQuiz.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .fillMaxHeight(0.3f))
        repeat(2) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {

                repeat(2) {
                    val respuesta = respuestas[it]
                    OutlinedButton(
                        onClick = {
                            if (respuesta == seleccioQuiz.correctAnswer) {
                                score++
                            }
                            if (numeroRonda < myViewModel.quantitatRondes) {
                                numeroRonda++

                            } else {
                                    navController.navigate(Routes.ResultScreen.route)
                            }
                        },
                        modifier = Modifier
                            .height(100.dp)
                            .width(200.dp)
                    ) {
                        Text(text = respuesta, style = TextStyle(color = Color.White,fontSize = 20.sp, textAlign = TextAlign.Center, fontFamily = FontFamily(Font(R.font.peachcake))))
                    }
                }
            }
        }
        Text(text ="Score: $score" , style = TextStyle(color = Color.White,fontSize = 20.sp, textAlign = TextAlign.Center, fontFamily = FontFamily(Font(R.font.peachcake))))
    }
}




