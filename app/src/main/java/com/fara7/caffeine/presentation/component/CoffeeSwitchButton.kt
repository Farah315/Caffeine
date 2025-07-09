package com.fara7.caffeine.presentation.component

import android.annotation.SuppressLint
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.EaseInOutQuint
import androidx.compose.animation.core.EaseInOutSine
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fara7.caffeine.R
import com.fara7.caffeine.presentation.theme.DeepBrown
import com.fara7.caffeine.presentation.theme.Peach
import com.fara7.caffeine.presentation.theme.SemiTransparentBlack
import com.fara7.caffeine.presentation.theme.SemiTransparentWhite
import com.fara7.caffeine.presentation.theme.SmokeGray
import com.fara7.caffeine.presentation.utils.Distances.spacing14

@SuppressLint("UseOfNonLambdaOffsetOverload")
@Composable
fun CoffeeSwitchButton() {
    val isChecked = remember { mutableStateOf(false) }
    val transition = updateTransition(targetState = isChecked.value)
    val switchOffset = transition.animateFloat(
        label = "switchTransition",
        transitionSpec = {
            tween(
                easing = EaseInOutQuint
            )
        }
    ) {
        if (it) 40f else 0f
    }
    val switchColor = transition.animateColor(
        label = "switchColor",
        transitionSpec = {
            tween(
                easing = EaseInOutSine

            )
        }
    ) {
        if (it) Peach else DeepBrown
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Box(
            modifier = Modifier
                .size(width = 78.dp, height = 40.dp)
                .clip(RoundedCornerShape(100.dp))
                .clickable { isChecked.value = !isChecked.value }
                .background(switchColor.value),
        ) {

            Text(
                text = if (isChecked.value) stringResource(id = R.string.toggle_off) else stringResource(id = R.string.toggle_on),
                color = if (isChecked.value) SemiTransparentBlack else SemiTransparentWhite,
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp,
                modifier = if (isChecked.value) Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = spacing14)
                else Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = spacing14),

                )

            Image(
                painter = painterResource(R.drawable.image_coffee_switcher),
                contentDescription = "coffee switch",
                modifier = Modifier.offset(x = switchOffset.value.dp)
            )
        }
        Text(
            text = stringResource(id = R.string.take_away),
            color = SmokeGray,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}
