package com.fara7.caffeine.presentation.screen.coffeeScreen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.fara7.caffeine.navigation.AppDestination

fun NavGraphBuilder.coffeeScreenRoute(navController: NavController) {
    composable(
        route = "${AppDestination.CoffeeScreen.route}/{title}",
        arguments = listOf(navArgument("title") { type = NavType.StringType })
    ) {
        CoffeeScreen(navController)
    }
}
