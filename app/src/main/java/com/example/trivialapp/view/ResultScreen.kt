package com.example.trivialapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trivialapp.R
import com.example.trivialapp.navigation.Routes
import com.example.trivialapp.viewmodel.MyViewModel

@Composable
fun ResultScreen(navController: NavController, myViewModel: MyViewModel) {
    Image(
        painter = painterResource(id = myViewModel.fonsPantalla),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "${myViewModel.score}/${myViewModel.quantitatRondes}", style = TextStyle(color = myViewModel.colorText,fontSize = 50.sp, textAlign = TextAlign.Center, fontFamily = FontFamily(Font(R.font.peachcake))))
        Text(text = "DIFICULTAD: ${myViewModel.dificultatEscollida}", style = TextStyle(color = myViewModel.colorText,fontSize = 40.sp, textAlign = TextAlign.Center, fontFamily = FontFamily(Font(R.font.peachcake))))
        Box(modifier = Modifier
            .width(130.dp)
            .clickable {navController.navigate(Routes.MenuScreen.route)}
            .background(Color.Transparent)
            .border(2.dp,myViewModel.colorText, shape = RoundedCornerShape(16.dp))
            .height(60.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "MENU",color = myViewModel.colorText, fontFamily = FontFamily(Font(R.font.peachcake)), style = TextStyle(fontSize = 30.sp), modifier = Modifier.align(Alignment.Center))
        }
    }
}


