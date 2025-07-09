package com.fara7.caffeine.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fara7.caffeine.model.CoffeeItem
import com.fara7.caffeine.presentation.theme.TextTitleColor
import com.fara7.caffeine.presentation.utils.Distances.spacing16


@Composable
fun CoffeeItem(
    modifier: Modifier = Modifier,
    coffee: CoffeeItem,
    imageScale: Float
) {
    Column(
        modifier = modifier,
        horizontalAlignment = CenterHorizontally,
    ) {
        Image(
            painter = painterResource(coffee.image),
            contentDescription = coffee.title,
            modifier = Modifier
                .scale(imageScale)
                .padding(bottom = spacing16)


        )
        Text(
            text = coffee.title,
            color = TextTitleColor,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}