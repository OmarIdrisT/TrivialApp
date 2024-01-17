package com.example.trivialapp.navigation

sealed class Routes(val route: String) {
    object LaunchScreen: Routes("com.example.trivialapp.LaunchScreen")
    object MenuScreen: Routes("com.example.trivialapp.MenuScreen")
    object Settings : Routes("com.example.trivialapp.Settings")
    object GameScreen: Routes("com.example.trivialapp.GameScreen") {
    }
    object ResultScreen: Routes("com.example.trivialapp.ResultScreen")
}