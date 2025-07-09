package com.fara7.caffeine.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.fara7.caffeine.presentation.screen.coffeeSectionScreen.CoffeeSectionScreen
import com.fara7.caffeine.presentation.screen.loadingScreen.LoadingScreen
import com.fara7.caffeine.presentation.screen.orderDoneScreen.OrderDoneScreen
import com.fara7.caffeine.presentation.screen.coffeeScreen.coffeeScreenRoute
import com.fara7.caffeine.presentation.screen.snackSectionScreen.SnackSectionScreen
import com.fara7.caffeine.presentation.screen.homeScreen.HomeScreen
import com.fara7.caffeine.presentation.screen.snacksSelectorScreen.SnacksSelectorScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AppDestination.HomeScreen.route
    ) {
        composable(AppDestination.HomeScreen.route) {
            HomeScreen(navController)
        }
        composable(AppDestination.CoffeeSectionScreen.route) {
            CoffeeSectionScreen(navController)
        }
        coffeeScreenRoute(navController)
        composable(
            route = "${AppDestination.LoadingScreen.route}/{currentSize}",
            arguments = listOf(
                navArgument("currentSize") {
                    type = NavType.StringType
                }
            )
        ) {
            LoadingScreen(navController)

        }
        composable(AppDestination.OrderDoneScreen.route) {
            OrderDoneScreen(navController)
        }
        composable(
            "${AppDestination.SnackSectionScreen.route}/{image}",
            arguments = listOf(
                navArgument("image") {
                    type = NavType.IntType
                }
            )) {
            SnackSectionScreen(navController)
        }
        composable(AppDestination.SnacksSelectorScreen.route) {
            SnacksSelectorScreen(navController)
        }


    }

}