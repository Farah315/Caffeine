package com.fara7.caffeine.presentation.component

import android.annotation.SuppressLint
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fara7.caffeine.R
import com.fara7.caffeine.presentation.theme.urbanist
import com.fara7.caffeine.presentation.theme.NightBlack
import com.fara7.caffeine.presentation.theme.LightGray
import com.fara7.caffeine.presentation.theme.TextTitleColor
import com.fara7.caffeine.presentation.utils.Distances.spacing12


@SuppressLint("UseOfNonLambdaOffsetOverload")
@Composable
fun ButtonHeader(
    modifier: Modifier = Modifier,
    title: String,
    spaceUnderButtonHeader: Dp,
    onBackClick: () -> Unit,
) {
    val headerOffsetY = remember { Animatable(300f) }
    val headerFade = remember { Animatable(0.2f) }

    LaunchedEffect(Unit) {
        headerOffsetY.animateTo(
            targetValue = 0f,
            animationSpec = tween(
                durationMillis = 600,
                easing = EaseInOut,

                )
        )
        headerFade.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 200,
            )
        )
    }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = spaceUnderButtonHeader)
            .offset(y = headerOffsetY.value.dp)
            .alpha(headerFade.value),
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(shape = CircleShape)
                .clickable { onBackClick() }
                .background(LightGray),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.icon_arrow_back),
                contentDescription = "back",
                tint = NightBlack,
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(Modifier.width(spacing12))
        Text(
            text = title,
            color = TextTitleColor,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = urbanist
        )


    }
}