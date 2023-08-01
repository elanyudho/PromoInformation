package com.example.promoinformation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.promoinformation.presentation.screens.Detail
import com.example.promoinformation.presentation.screens.Home
import com.example.promoinformation.presentation.viewmodel.HomeViewModel


@Composable
fun NavGraph(navController: NavHostController, homeViewModel: HomeViewModel) {

    NavHost(
        navController = navController,
        startDestination = Screens.Home.route
    )
    {
        composable(route = Screens.Home.route) {
            Home(navController, homeViewModel)
        }
        composable(
            route = "${Screens.Detail.route}/{index}",
            arguments = listOf(navArgument("index") { type = NavType.StringType })
        ) {
            val index = it.arguments?.getInt("index") ?: 0

            Detail(index = index, homeViewModel)
        }
    }
}