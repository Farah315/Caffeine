package com.fara7.caffeine.navigation

sealed class AppDestination(val route: String) {
    object HomeScreen : AppDestination("HomeScreen")
    object CoffeeSectionScreen : AppDestination("CoffeeSectionScreen")
    object CoffeeScreen : AppDestination("CoffeeScreen")
    object LoadingScreen : AppDestination("LoadingScreen")
    object OrderDoneScreen : AppDestination("OrderDoneScreen")
    object SnackSectionScreen : AppDestination("SnackSectionScreen")
    object SnacksSelectorScreen : AppDestination("SnacksSelectorScreen")
}
