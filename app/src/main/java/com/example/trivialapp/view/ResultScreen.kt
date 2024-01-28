package com.example.trivialapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.trivialapp.R
import com.example.trivialapp.viewmodel.MyViewModel

@Composable
fun ResultScreen(navController: NavController, myViewModel: MyViewModel) {
    Image(
        painter = painterResource(id = R.drawable.fondo),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
    Column() {
        Text(text = "${myViewModel.tempsPerRonda}, ${myViewModel.quantitatRondes}, ${myViewModel.score}")
    }
}