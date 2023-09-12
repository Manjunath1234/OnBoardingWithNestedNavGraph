package com.example.onboardingwithnewsplashapi.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.example.onboardingwithnewsplashapi.screen.HomeScreen
import com.example.onboardingwithnewsplashapi.screen.WelcomeScreen


@ExperimentalAnimationApi

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Screen.Welcome.route) {
            WelcomeScreen(navController=navController)
        }
        composable(route = Screen.Home.route) {
            HomeScreen()
        }
    }
}