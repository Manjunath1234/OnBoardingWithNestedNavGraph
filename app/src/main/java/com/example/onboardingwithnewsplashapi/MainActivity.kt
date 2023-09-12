package com.example.onboardingwithnewsplashapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.onboardingwithnewsplashapi.navigation.SetupNavGraph
import com.example.onboardingwithnewsplashapi.ui.theme.OnBoardingWithNewSplashApiTheme
import com.example.onboardingwithnewsplashapi.viewmodel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var splashViewModel: SplashViewModel


    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        installSplashScreen().setKeepOnScreenCondition {

            !splashViewModel.isLoading.value
        }

        setContent {
            OnBoardingWithNewSplashApiTheme {
                //splashViewModel= hiltViewModel()
                if (::splashViewModel.isInitialized){
                    val screen by splashViewModel.startDestination
                    val navController = rememberNavController()
                    SetupNavGraph(navController = navController, startDestination = screen)
            }

            }
        }
    }
}
