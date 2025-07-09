package com.fara7.caffeine.presentation.screen.snacksSelectorScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.fara7.caffeine.presentation.component.ExitHeader
import com.fara7.caffeine.presentation.component.SnackSlider
import com.fara7.caffeine.navigation.AppDestination
import com.fara7.caffeine.presentation.theme.TextTitleColor
import com.fara7.caffeine.presentation.theme.urbanist
import com.fara7.caffeine.presentation.utils.Distances.spacing16


@Composable
fun SnacksSelectorScreen(
    navController: NavController
) {

    SnacksSelectorContent(

        onClick = { image ->
            navController.navigate("${AppDestination.SnackSectionScreen.route}/${image}")
        },
        onExitClick = {
            navController.popBackStack(
                route = AppDestination.HomeScreen.route,
                inclusive = false
            )
        }
    )
}

@Composable
fun SnacksSelectorContent(
    onClick: (Int) -> Unit,
    onExitClick: () -> Unit,
) {
    Scaffold(
        containerColor = Color.White
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
                .padding(vertical = spacing16),


            ) {
            ExitHeader(
                spaceUnderExitHeader = spacing16,
                modifier = Modifier.padding(horizontal = spacing16),
                onClick = onExitClick
            )
            Text(
                text = "Take your snack",
                color = TextTitleColor,
                modifier = Modifier
                    .padding(horizontal = spacing16)
                    .background(Color.Transparent),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = urbanist
            )

            SnackSlider(
                onClick = onClick
            )

        }

    }
}


