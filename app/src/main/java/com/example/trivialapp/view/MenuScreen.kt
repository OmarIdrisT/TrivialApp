package com.example.trivialapp.view

import android.content.res.Configuration
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import com.example.trivialapp.R
import com.example.trivialapp.navigation.Routes
import com.example.trivialapp.viewmodel.MyViewModel


@Composable
fun MenuScreen(navController: NavController, myViewModel: MyViewModel) {
    val colorNaranja = Color(0xffffa420)
    var colorTitle = listOf(Color.Red, Color.Yellow, colorNaranja, Color.Cyan, Color.Magenta, Color.Green, Color.Red)
    val title = "TRIVIAL"
    val configuration = LocalConfiguration.current
    var landscape = false

    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            landscape = true
        }

        else -> {
            landscape = false
        }
    }

    Box (modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = myViewModel.fonsPantalla),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column (
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "portada", modifier = Modifier.fillMaxWidth(if (!landscape) 0.5f else (0.3f)).fillMaxHeight(if (!landscape) 0.4f else (0.3f)))
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                for (lletra in 0 until title.length) {
                    Text(
                        text = title[lletra].toString(),
                        color = colorTitle[lletra],
                        fontFamily = FontFamily(Font(R.font.peachcake)),
                        style = TextStyle(fontSize = if (!landscape) 70.sp else 30.sp)
                    )
                }
            }
            Spacer(modifier = Modifier.fillMaxHeight(0.1f))
            Box(modifier = Modifier
                .fillMaxWidth(if (!landscape) 0.275f else 0.2f)
                .clickable {
                    navController.navigate(Routes.GameScreen.route)
                    myViewModel.reiniciarScore()
                }
                .background(Color.Transparent)
                .border(2.dp, myViewModel.colorText, shape = RoundedCornerShape(16.dp))
                .fillMaxHeight(0.15f),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "PLAY", color = myViewModel.colorText, fontFamily = FontFamily(Font(R.font.peachcake)),  style = TextStyle(fontSize = if (!landscape) 30.sp else 20.sp))
            }

            Spacer(modifier = Modifier.fillMaxHeight(0.1f))

            Box(modifier = Modifier
                .fillMaxWidth(if (!landscape) 0.275f else 0.2f)
                .clickable { (navController.navigate(Routes.Settings.route)) }
                .background(Color.Transparent)
                .border(2.dp, myViewModel.colorText, shape = RoundedCornerShape(16.dp))
                .fillMaxHeight(0.195f),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "HELP",color = myViewModel.colorText, fontFamily = FontFamily(Font(R.font.peachcake)), style = TextStyle(fontSize = if (!landscape) 30.sp else 20.sp), modifier = Modifier.align(Alignment.Center))
            }
        }
    }

}


