package com.example.trivialapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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

@Composable
fun Settings(navController: NavController) {

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
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(text = "Dificultat:", style = TextStyle(color = Color.White,fontSize = 20.sp, textAlign = TextAlign.Center, fontFamily = FontFamily(Font(R.font.peachcake))))
            val dificultatEscollida = myDropDownMenu()
        }
        Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Text(text = "Nombre de rondes:", style = TextStyle(color = Color.White,fontSize = 20.sp, textAlign = TextAlign.Center, fontFamily = FontFamily(Font(R.font.peachcake))))
            val rondes = numberOfRounds()
        }
        Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            val tempsRondes = timePerRound()
        }
        Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Text(text = "Mode fosc:", style = TextStyle(color = Color.White,fontSize = 20.sp, textAlign = TextAlign.Center, fontFamily = FontFamily(Font(R.font.peachcake))))
            var modeFosc by rememberSaveable { mutableStateOf(false) }
            Switch(checked = modeFosc,
                onCheckedChange = { modeFosc = !modeFosc },
                colors = SwitchDefaults.colors(
                    uncheckedThumbColor = Color.White,
                    checkedThumbColor = Color.Cyan
                ))
        }
        Box(modifier = Modifier
            .width(130.dp)
            .clickable { (navController.navigate(Routes.MenuScreen.route))}
            .background(Color.DarkGray)
            .height(60.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "MENÚ", fontFamily = FontFamily(Font(R.font.peachcake)), style = TextStyle(color = Color.White, fontSize = 30.sp), modifier = Modifier.align(Alignment.Center))
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myDropDownMenu(): String {
    var dificultatGame by remember { mutableStateOf("FACIL") }
    var expanded by remember { mutableStateOf(false) }
    val opcions = listOf("FACIL", "NORMAL", "DIFICIL")

    Column (modifier = Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = dificultatGame,
            onValueChange = { dificultatGame = it },
            enabled = false,
            readOnly = true,
            textStyle = TextStyle(color = Color.White, fontFamily = FontFamily(Font(R.font.peachcake)), fontSize = 20.sp, textAlign = TextAlign.Center),
            modifier = Modifier
                .clickable { expanded = true }
                .width(120.dp)
                .height(60.dp)
                .background(color = Color.DarkGray)
                .align(alignment = Alignment.CenterHorizontally)
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            opcions.forEach { dificultat ->
                DropdownMenuItem(modifier = Modifier.background(color = Color.Transparent) ,text = { Text(text = dificultat, style = TextStyle(color = Color.White, fontFamily = FontFamily(Font(R.font.peachcake)))) }, onClick = {
                    expanded = false
                    dificultatGame = dificultat
                })
            }
        }
    }

    return dificultatGame
}

@Composable
fun numberOfRounds() {
    val opcions = listOf(5, 10, 15)
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(opcions[0]) }

    Column(Modifier.selectableGroup()) {
        opcions.forEach { text ->
            Row(
                Modifier
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) }
                    ),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) }
                )
                Text(
                    text = "$text",
                    style = TextStyle(color = Color.White,fontSize = 20.sp, textAlign = TextAlign.Center, fontFamily = FontFamily(Font(R.font.peachcake)))
                )
            }

        }
    }
}


@Composable
fun timePerRound() {
    var valorTemps by remember { mutableStateOf(20f) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth(0.7f)
    ) {
        Text(text = "${valorTemps.toInt()} segons", style = TextStyle(color = Color.White,fontSize = 20.sp, textAlign = TextAlign.Center, fontFamily = FontFamily(Font(R.font.peachcake))))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Temps per ronda:", style = TextStyle(color = Color.White,fontSize = 20.sp, textAlign = TextAlign.Center, fontFamily = FontFamily(Font(R.font.peachcake))))
            Slider(
                value = valorTemps,
                onValueChange = {valorTemps = it},
                valueRange = 10f..30f,
                steps = 3
            )
        }

    }
}