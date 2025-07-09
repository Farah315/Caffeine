package com.fara7.caffeine.presentation.screen.snackSectionScreen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.fara7.caffeine.R
import com.fara7.caffeine.presentation.component.ExitHeader
import com.fara7.caffeine.presentation.component.IconTextButton
import com.fara7.caffeine.navigation.AppDestination
import com.fara7.caffeine.presentation.theme.DeepBrown
import com.fara7.caffeine.presentation.theme.siglet
import com.fara7.caffeine.presentation.theme.urbanist
import com.fara7.caffeine.presentation.utils.Distances.spacing16
import com.fara7.caffeine.presentation.utils.Distances.spacing24

@Composable
fun SnackSectionScreen(
    navController: NavController
) {
    val args: Int? = navController.currentBackStackEntry?.arguments?.getInt("image")

    val scaleTransition = remember { Animatable(0.5f) }
    val fadeTransition = remember { Animatable(0.7f) }


    LaunchedEffect(Unit) {
        scaleTransition.animateTo(
            targetValue = 1f,
            animationSpec = tween(
            )
        )
        fadeTransition.animateTo(
            targetValue = 1f,
            animationSpec = tween(
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
            ExitHeader(
                spaceUnderExitHeader = spacing24, modifier = Modifier.padding(horizontal = spacing16),
                onClick = {
                    navController.popBackStack(
                        route = AppDestination.HomeScreen.route,
                        inclusive = false
                    )
                }
            )
            Row(modifier = Modifier.padding(bottom = spacing24)) {
                Icon(
                    painter = painterResource(R.drawable.image_coffee_beans2),
                    contentDescription = "",
                    tint = DeepBrown,
                    modifier = Modifier.padding(end = spacing16)
                )
                Text(
                    text = "More Espresso, Less Depresso",
                    color = DeepBrown,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = siglet
                )
                Icon(
                    painter = painterResource(R.drawable.image_coffee_beans2),
                    contentDescription = "",
                    modifier = Modifier.padding(start = spacing16),
                    tint = DeepBrown,

                    )
            }

            Image(
                painter = painterResource(checkNotNull(args)),
                contentDescription = "Product Image",
                modifier = Modifier
                    .size(300.dp)
                    .scale(scaleTransition.value)
                    .alpha(fadeTransition.value)
            )
            Row(
                modifier = Modifier.padding(top = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Bon appétit",
                    color = Color(0xCC1F1F1F),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = urbanist,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Image(
                    painter = painterResource(R.drawable.magic_wand),
                    contentDescription = "magic wand",

                    )
            }

            Spacer(modifier = Modifier.weight(1f))
            IconTextButton(
                onClick = {
                    navController.popBackStack(
                        route = AppDestination.HomeScreen.route,
                        inclusive = false
                    )

                },
                text = "Thank youuu",
                icon = painterResource(R.drawable.icon_arrow_right)
            )


        }
    }

}



