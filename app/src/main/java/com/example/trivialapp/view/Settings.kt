package com.example.trivialapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
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
import com.example.trivialapp.R
import com.example.trivialapp.navigation.Routes
import com.example.trivialapp.viewmodel.MyViewModel


val colorBotons = Color(0xffBB12F1)

@Composable
fun Settings(navController: NavController, myViewModel: MyViewModel) {

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
            Text(text = "Dificultat:", style = TextStyle(color = Color.White,fontSize = 20.sp, textAlign = TextAlign.Center, fontFamily = FontFamily(Font(
                R.font.peachcake
            ))))
            myDropDownMenu(myViewModel)
        }
        Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Text(text = "Nombre de rondes:", style = TextStyle(color = Color.White,fontSize = 20.sp, textAlign = TextAlign.Center, fontFamily = FontFamily(Font(
                R.font.peachcake
            ))))
            numberOfRounds(myViewModel)
        }
        Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            timePerRound(myViewModel)
        }
        Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Text(text = "Mode fosc:", style = TextStyle(color = Color.White,fontSize = 20.sp, textAlign = TextAlign.Center, fontFamily = FontFamily(Font(
                R.font.peachcake
            ))))

            Switch(checked = myViewModel.modeFosc,
                onCheckedChange = { myViewModel.canviarMode(it) },
                colors = SwitchDefaults.colors(
                    uncheckedThumbColor = Color.White,
                    checkedThumbColor = Color.Cyan,
                    uncheckedTrackColor = Color.White,
                    checkedTrackColor = colorBotons,
                ))
        }
        BoxWithConstraints(modifier = Modifier
            .width(130.dp)
            .clickable { (navController.navigate(Routes.MenuScreen.route)) }
            .background(Color.Transparent)
            .border(2.dp, Color.White, shape = RoundedCornerShape(16.dp))
            .height(60.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "MENÚ", fontFamily = FontFamily(Font(R.font.peachcake)), style = TextStyle(color = Color.White, fontSize = 30.sp), modifier = Modifier.align(Alignment.Center))
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myDropDownMenu(myViewModel: MyViewModel) {
    var expanded by remember { mutableStateOf(false) }
    val opcions = listOf("FACIL", "NORMAL", "DIFICIL")

    Column (modifier = Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = myViewModel.dificultatEscollida,
            onValueChange = { myViewModel.canviarDificultat(it) },
            enabled = false,
            readOnly = true,
            textStyle = TextStyle(color = Color.White, fontFamily = FontFamily(Font(R.font.peachcake)), fontSize = 20.sp, textAlign = TextAlign.Center),
            modifier = Modifier
                .clickable { expanded = true }
                .width(120.dp)
                .height(60.dp)
                .border(2.dp, Color.White, shape = RoundedCornerShape(16.dp))
                .background(color = Color.Transparent)
                .align(alignment = Alignment.CenterHorizontally)
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            opcions.forEach { dificultat ->
                DropdownMenuItem(modifier = Modifier.background(color = Color.Transparent) ,text = { Text(text = dificultat, style = TextStyle(color = Color.White, fontFamily = FontFamily(Font(
                    R.font.peachcake
                )))) }, onClick = {
                    expanded = false
                    myViewModel.canviarDificultat(dificultat)
                })
            }
        }
    }
}

@Composable
fun numberOfRounds(myViewModel: MyViewModel) {
    val opcions = listOf(5, 10, 15)

    Column(Modifier.selectableGroup()) {
        opcions.forEach { text ->
            Row(
                Modifier
                    .selectable(
                        selected = (myViewModel.quantitatRondes == text),
                        onClick = { myViewModel.canviarRondes(text) }
                    ),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (myViewModel.quantitatRondes == text),
                    onClick = { myViewModel.canviarRondes(text)},
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Cyan,
                        unselectedColor = Color.White
                    )
                )
                Text(
                    text = "$text",
                    style = TextStyle(color = Color.White,fontSize = 20.sp, textAlign = TextAlign.Center, fontFamily = FontFamily(Font(
                        R.font.peachcake
                    )))
                )
            }

        }
    }
}


@Composable
fun timePerRound(myViewModel: MyViewModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth(0.7f)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Temps per ronda:", style = TextStyle(color = Color.White,fontSize = 20.sp, textAlign = TextAlign.Center, fontFamily = FontFamily(Font(
                R.font.peachcake
            ))))
            Slider(
                value = myViewModel.tempsPerRonda,
                onValueChange = {myViewModel.canviarTemps(it)},
                valueRange = 10f..30f,
                steps = 3,
                colors = SliderDefaults.colors(
                    thumbColor = Color.Cyan,
                    activeTrackColor = Color.Cyan,
                    inactiveTrackColor = Color.White
                )
            )
        }
        Text(text = "${myViewModel.tempsPerRonda.toInt()} segons", style = TextStyle(color = Color.White,fontSize = 20.sp, textAlign = TextAlign.Center, fontFamily = FontFamily(Font(
            R.font.peachcake
        ))))

    }
}