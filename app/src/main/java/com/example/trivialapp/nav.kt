package com.example.trivialapp

sealed class Routes(val route: String) {
    object LaunchScreen: Routes("com.example.trivialapp.LaunchScreen")
    object MenuScreen: Routes("com.example.trivialapp.MenuScreen")
    object Settings : Routes("com.example.trivialapp.Settings")
    object GameScreen: Routes("com.example.trivialapp.GameScreen/{dificultatEscollida}") {
        fun createRoute(dificultatEscollida:String) = "com.example.hangmanapp.GameScreen/$dificultatEscollida"
    }
    object ResultScreen: Routes("com.example.trivialapp.ResultScreen")
}