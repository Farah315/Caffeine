package com.fara7.caffeine.presentation.screen.homeScreen

import android.annotation.SuppressLint
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fara7.caffeine.R
import com.fara7.caffeine.presentation.component.TopHeader
import com.fara7.caffeine.presentation.component.IconTextButton
import com.fara7.caffeine.presentation.component.HomeScreenText
import com.fara7.caffeine.navigation.AppDestination
import com.fara7.caffeine.presentation.utils.Distances.spacing16
import com.fara7.caffeine.presentation.utils.Distances.spacing24

@SuppressLint("UseOfNonLambdaOffsetOverload")
@Composable
fun HomeScreen(
    navController: NavController
) {
    val infiniteTransition = rememberInfiniteTransition()
    val offsetValue = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = -30f,
        label = "offsetValue",
        animationSpec = infiniteRepeatable(
            animation = tween(1700),
            repeatMode = RepeatMode.Reverse
        )
    )
    val shadowValue = infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 0.5f,
        label = "shadowValue",
        animationSpec = infiniteRepeatable(
            animation = tween(
                1700,
            ),
            repeatMode = RepeatMode.Reverse
        )
    )
    val shadowSize = infiniteTransition.animateFloat(
        initialValue = 0.85f,
        targetValue = 1f,
        label = "shadowValue",
        animationSpec = infiniteRepeatable(
            animation = tween(1700),
            repeatMode = RepeatMode.Reverse,
        )
    )
    Scaffold(
        containerColor = Color.White
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .padding(spacing16),
            horizontalAlignment = CenterHorizontally
        ) {
            TopHeader(spaceUnderTopHeader = spacing24)
            HomeScreenText()
            Image(
                painter = painterResource(R.drawable.image_coffee_ghost),
                contentDescription = "",
                modifier = Modifier.offset(y = offsetValue.value.dp)
            )
            Image(
                painter = painterResource(R.drawable.image_shadow),
                contentDescription = "shadow",
                modifier = Modifier
                    .alpha(shadowValue.value)
                    .scale(shadowSize.value)

            )
            Spacer(modifier = Modifier.weight(1f))
            IconTextButton(
                text = "bring my coffee",
                icon = painterResource(R.drawable.image_coffee),
                onClick = { navController.navigate(AppDestination.CoffeeSectionScreen.route) }
            )



        }

    }
}


