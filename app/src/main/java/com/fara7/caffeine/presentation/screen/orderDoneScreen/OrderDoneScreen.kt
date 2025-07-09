package com.fara7.caffeine.presentation.screen.orderDoneScreen

import android.annotation.SuppressLint
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fara7.caffeine.R
import com.fara7.caffeine.presentation.component.CoffeeSeparatedCup
import com.fara7.caffeine.presentation.component.CoffeeSwitchButton
import com.fara7.caffeine.presentation.component.ExitHeader
import com.fara7.caffeine.presentation.component.IconTextButton
import com.fara7.caffeine.presentation.component.OrderReadyText
import com.fara7.caffeine.navigation.AppDestination
import com.fara7.caffeine.presentation.utils.Distances.spacing16

@SuppressLint("UseOfNonLambdaOffsetOverload")
@Composable
fun OrderDoneScreen(
    navController: NavController
) {
    val msgOffset = remember { Animatable(-1000f) }
    val buttonOffsetY = remember { Animatable(300f) }

    LaunchedEffect(Unit) {
        msgOffset.animateTo(
            targetValue = 0f,
            animationSpec = tween(
                1000
            )
        )
    }

    LaunchedEffect(Unit) {
        buttonOffsetY.animateTo(
            targetValue = 0f,
            animationSpec = tween(
                1000
            )
        )
    }
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
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = msgOffset.value.dp),
                horizontalAlignment = CenterHorizontally
            ) {
                ExitHeader(
                    spaceUnderExitHeader = spacing16,
                    modifier = Modifier.padding(horizontal =spacing16),
                    onClick = {
                        navController.popBackStack(
                            route = AppDestination.HomeScreen.route,
                            inclusive = false
                        )
                    }
                )
                OrderReadyText()
            }
            CoffeeSeparatedCup()
            Spacer(modifier = Modifier.weight(1f))
            CoffeeSwitchButton()
            Spacer(modifier = Modifier.height(spacing16))
            IconTextButton(
                onClick = {
                    navController.navigate(AppDestination.SnacksSelectorScreen.route)
                },
                text = "Take snack",
                icon = painterResource(R.drawable.icon_arrow_right),
                modifier = Modifier
                    .offset(y = buttonOffsetY.value.dp)
            )
        }

    }
}






