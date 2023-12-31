package com.example.onboardingwithnewsplashapi.navigation

sealed class Screen (val route:String){
    object Home:Screen(route = "home_screen")
    object Welcome:Screen(route = "welcome_screen")
}