package com.example.trivialapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.trivialapp.ui.theme.TrivialAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrivialAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.LaunchScreen.route
                    ) {
                        composable(Routes.LaunchScreen.route) { LaunchScreen(navigationController) }
                        composable(Routes.MenuScreen.route) { MenuScreen(navigationController) }
                        composable(
                            Routes.GameScreen.route,
                            arguments = listOf(navArgument("dificultatEscollida") {type = NavType.StringType})
                        ) { backStackEntry ->
                            GameScreen(
                                navigationController,
                                backStackEntry.arguments?.getString("dificultatEscollida") ?: "EASY",
                                backStackEntry.arguments?.getBoolean("musicaOn") ?: true
                            )
                        }
                        composable(
                            Routes.ResultScreen.route,
                            arguments = listOf(navArgument("victoria") {type = NavType.BoolType}, navArgument("tries") {type = NavType.IntType}, navArgument("dificultatEscollida") {type = NavType.StringType})
                        ) {backStackEntry ->
                            ResultScreen(
                                navigationController,
                                backStackEntry.arguments?.getBoolean("victoria") ?: false,
                                backStackEntry.arguments?.getInt("tries") ?: 0,
                                backStackEntry.arguments?.getString("dificultatEscollida") ?: "Easy",
                                backStackEntry.arguments?.getBoolean("musicaOn") ?: true
                            )
                        }
                    }
                }
            }
        }
    }
}