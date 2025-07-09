package com.fara7.caffeine.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.fara7.caffeine.presentation.theme.DarkGray
import com.fara7.caffeine.presentation.theme.Gray70
import com.fara7.caffeine.presentation.theme.urbanist
import com.fara7.caffeine.presentation.utils.Distances.spacing16
import com.fara7.caffeine.presentation.utils.Distances.spacing50


@Composable
fun WelcomeText() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = spacing16, end = spacing16, bottom = spacing50),
        horizontalAlignment = Alignment.Start

    ) {
        Text(
            text = "Good Morning",
            color = Gray70,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = urbanist,
        )
        Text(
            text = "Heba ☀",
            color = DarkGray,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = urbanist,
        )
        Text(
            text = "What would you like to drink today?",
            color = DarkGray,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = urbanist,
        )
    }
}