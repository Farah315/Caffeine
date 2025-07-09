package com.fara7.caffeine.presentation.screen.coffeeSectionScreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.fara7.caffeine.R
import com.fara7.caffeine.component.CoffeeSlider
import com.fara7.caffeine.presentation.component.TopHeader
import com.fara7.caffeine.presentation.component.IconTextButton
import com.fara7.caffeine.presentation.component.WelcomeText
import com.fara7.caffeine.model.coffeeTypeList
import com.fara7.caffeine.navigation.AppDestination
import com.fara7.caffeine.presentation.utils.Distances.spacing16


@Composable
fun CoffeeSectionScreen(
    navController: NavController

) {
    val currentCoffeeTitle = remember { mutableStateOf(coffeeTypeList.first().title) }

    val isVisible = remember { mutableStateOf(true) }

    Scaffold(
        containerColor = Color.White
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
                .padding(vertical = spacing16),

            horizontalAlignment = CenterHorizontally,

            ) {

            AnimatedVisibility(
                visible = isVisible.value,
                exit = slideOutHorizontally(tween(durationMillis = 700)) { -it }
            ) {
                TopHeader(spaceUnderTopHeader = spacing16, modifier = Modifier.padding(horizontal = spacing16))
            }
            WelcomeText()
            CoffeeSlider(onSelectionChanged = {
                currentCoffeeTitle.value = it
            })
            Spacer(modifier = Modifier.weight(1f))
            AnimatedVisibility(
                visible = isVisible.value,
                exit = slideOutHorizontally(tween(durationMillis = 700)) { -it }
            ) {
            IconTextButton(
                text = stringResource(id = R.string.continue_text),
                icon = painterResource(R.drawable.icon_arrow_right),
                onClick = {
                    isVisible.value = false
                    navController.navigate("${AppDestination.CoffeeScreen.route}/${currentCoffeeTitle.value}")
                }
            )
            }

        }

    }
}



