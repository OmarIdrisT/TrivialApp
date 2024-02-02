package com.example.trivialapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trivialapp.navigation.Routes
import com.example.trivialapp.viewmodel.MyViewModel
import com.example.trivialapp.view.GameScreen
import com.example.trivialapp.view.LaunchScreen
import com.example.trivialapp.view.MenuScreen
import com.example.trivialapp.view.ResultScreen
import com.example.trivialapp.view.Settings
import com.example.trivialapp.ui.theme.TrivialAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        val myViewModel by viewModels<MyViewModel>()
        super.onCreate(savedInstanceState)
        setContent {
            val windowSize = calculateWindowSizeClass(this)
            val windowWidth = windowSize.widthSizeClass
            val windowHeight = windowSize.heightSizeClass

            TrivialAppTheme (myViewModel) {
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
                        composable(Routes.MenuScreen.route) { MenuScreen(navigationController, myViewModel) }
                        composable(Routes.Settings.route) { Settings(navigationController, myViewModel) }
                        composable(Routes.GameScreen.route){GameScreen(navigationController, myViewModel)}
                        composable(Routes.ResultScreen.route) {ResultScreen(navigationController, myViewModel)}
                    }
                }
            }
        }
    }
}