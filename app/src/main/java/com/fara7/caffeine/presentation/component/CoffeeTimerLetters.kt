package com.fara7.caffeine.presentation.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.fara7.caffeine.presentation.theme.DeepBrown
import com.fara7.caffeine.presentation.theme.Gray12
import com.fara7.caffeine.presentation.theme.siglet
import com.fara7.caffeine.presentation.utils.Distances.spacing12


@Composable
fun CoffeeTimerLetters() {
    val coffeeText = buildAnnotatedString {
        append("CO ")
        withStyle(style = SpanStyle(color = Gray12)) {
            append(":")
        }
        append(" FF ")
        withStyle(style = SpanStyle(color = Gray12)) {
            append(":")
        }
        append(" EE")

    }
    Text(
        modifier = Modifier.padding(top = spacing12),
        text = coffeeText,
        fontFamily = siglet,
        color = DeepBrown,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 32.sp
    )
}
