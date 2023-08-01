package com.example.promoinformation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.promoinformation.presentation.viewmodel.HomeViewModel
import com.example.promoinformation.ui.navigation.NavGraph
import com.example.promoinformation.ui.theme.PromoInformationTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PromoInformationTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                NavGraph(navController = navController, homeViewModel)
            }
        }
    }

}
