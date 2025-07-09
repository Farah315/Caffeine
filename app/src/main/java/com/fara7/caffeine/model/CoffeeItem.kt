package com.fara7.caffeine.model

import com.fara7.caffeine.R

data class CoffeeItem(
    val title: String,
    val image: Int,
)

val coffeeTypeList = listOf(
    CoffeeItem("Black", R.drawable.image_black),
    CoffeeItem("Latte", R.drawable.image_latte),
    CoffeeItem("Macchiato", R.drawable.image_macchiato),
    CoffeeItem("Espresso", R.drawable.image_espreesso),
)