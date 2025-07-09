package com.fara7.caffeine.presentation.component

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fara7.caffeine.R
import com.fara7.caffeine.presentation.theme.CoffeeLabelColor
import com.fara7.caffeine.presentation.theme.CoffeeShadow
import com.fara7.caffeine.presentation.theme.DeepBrown
import com.fara7.caffeine.presentation.theme.LightGray7
import com.fara7.caffeine.presentation.theme.AlmostOpaqueWhite
import com.fara7.caffeine.presentation.utils.modifier.dropShadow
import com.fara7.caffeine.presentation.theme.urbanist
import com.fara7.caffeine.presentation.utils.Distances.spacing10
import com.fara7.caffeine.presentation.utils.Distances.spacing4
import com.fara7.caffeine.presentation.utils.Distances.spacing8


@Composable
fun CoffeeSelector(
    allLevels: List<String> = listOf("Low", "Medium", "High"),
    onClick: (String) -> Unit = {},
    currentCoffeeLevel: String
) {

    Column {

        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(100.dp))
                .background(LightGray7)
                .padding(horizontal = spacing4, vertical =spacing8)
        )
        {

            allLevels.forEach { level ->
                val isSelected = level == currentCoffeeLevel
                val transition = updateTransition(targetState = isSelected)
                val backgroundColor =
                    transition.animateColor(transitionSpec = { tween(easing = EaseInOut) }) {
                        when (it) {
                            true -> DeepBrown
                            false -> Color.Transparent
                        }
                    }

                Box(
                    Modifier
                        .padding(horizontal =spacing4)
                        .then(
                            if (isSelected) Modifier
                                .dropShadow(
                                    shape = CircleShape,
                                    color = CoffeeShadow,
                                    blur = 16.dp,
                                    offsetY = 6.dp,
                                ) else Modifier
                        )
                        .size(40.dp)
                        .clip(CircleShape)
                        .clickable { onClick(level) }
                        .background(backgroundColor.value)
                        .padding(horizontal = spacing10, vertical = spacing8),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.image_coffee_beans),
                        contentDescription = "Product Image",
                        tint = if (isSelected) AlmostOpaqueWhite else Color.Transparent,
                    )
                }

            }
        }

        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .padding(horizontal = spacing4)

        ) {

            allLevels.forEach { level ->

                Text(
                    text = level,
                    color = CoffeeLabelColor,
                    fontSize = 10.sp,
                    fontFamily = urbanist,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(horizontal = spacing10)
                )
            }
        }
    }
}