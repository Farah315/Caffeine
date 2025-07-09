package com.fara7.caffeine.presentation.component

import android.annotation.SuppressLint
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fara7.caffeine.R
import com.fara7.caffeine.presentation.utils.Distances.spacing10
import com.fara7.caffeine.presentation.utils.Distances.spacing30

@SuppressLint("UseOfNonLambdaOffsetOverload")
@Composable
fun CoffeeSeparatedCup() {
    val coverOffset = remember { Animatable(-1000f) }

    LaunchedEffect(Unit) {
        coverOffset.animateTo(
            targetValue = 0f,
            animationSpec = tween(
                1000
            )
        )
    }
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopCenter

    ) {
        Image(
            painter = painterResource(R.drawable.image_big_cup),
            contentDescription = "Product Image",
            modifier = Modifier
                .padding(top = spacing30)


            )
        Image(
            painter = painterResource(R.drawable.image_cup_cover),
            contentDescription = "Product Image",
            modifier = Modifier
                .padding(top = spacing10)
                .offset(y = coverOffset.value.dp),


            )
    }
}