package com.fara7.caffeine.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fara7.caffeine.R
import com.fara7.caffeine.presentation.theme.AlmostOpaqueWhite
import com.fara7.caffeine.presentation.theme.CoffeeShadow
import com.fara7.caffeine.presentation.theme.DeepBrown
import com.fara7.caffeine.presentation.theme.TextTitleColor
import com.fara7.caffeine.presentation.utils.modifier.dropShadow
import com.fara7.caffeine.presentation.theme.urbanist
import com.fara7.caffeine.presentation.utils.Distances.spacing10
import com.fara7.caffeine.presentation.utils.Distances.spacing24
import com.fara7.caffeine.presentation.utils.Distances.spacing8


@Composable
fun OrderReadyText() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally,
        modifier = Modifier.width(270.dp)
    ) {

        Box(
            Modifier
                .padding(bottom = spacing24)
                .dropShadow(
                    shape = CircleShape,
                    color = CoffeeShadow,
                    blur = 16.dp,
                    offsetY = 6.dp,
                )
                .size(56.dp)
                .clip(CircleShape)
                .background(DeepBrown)
                .padding(horizontal = spacing10, vertical = spacing8),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.icon_true),
                contentDescription = "",
                tint = AlmostOpaqueWhite,
            )
        }
        Text(
            text = "Your coffee is ready,\nEnjoy",
            color = TextTitleColor,
            fontSize = 22.sp,
            fontFamily = urbanist,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            letterSpacing = 0.25.sp,
        )
    }
}