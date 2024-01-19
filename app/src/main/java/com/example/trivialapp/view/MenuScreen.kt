package com.example.trivialapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trivialapp.R
import com.example.trivialapp.navigation.Routes
import com.example.trivialapp.viewmodel.MyViewModel

@Composable
fun MenuScreen(navController: NavController, myViewModel: MyViewModel) {

    Box (modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.fondo),
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
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "portada", modifier = Modifier.size(200.dp))
            Spacer(modifier = Modifier.height(30.dp))
            Spacer(modifier = Modifier.height(30.dp))
            Box(modifier = Modifier
                .width(130.dp)
                .clickable { navController.navigate(Routes.GameScreen.route)}
                .background(Color.Transparent)
                .border(2.dp,Color.White, shape = RoundedCornerShape(16.dp))
                .height(60.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "PLAY", fontFamily = FontFamily(Font(R.font.peachcake)),  style = TextStyle(color = Color.White, fontSize = 30.sp))
            }

            Spacer(modifier = Modifier.height(30.dp))

            Box(modifier = Modifier
                .width(130.dp)
                .clickable { (navController.navigate(Routes.Settings.route))}
                .background(Color.Transparent)
                .border(2.dp,Color.White, shape = RoundedCornerShape(16.dp))
                .height(60.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "HELP", fontFamily = FontFamily(Font(R.font.peachcake)), style = TextStyle(color = Color.White, fontSize = 30.sp), modifier = Modifier.align(Alignment.Center))
            }
        }
    }

}


