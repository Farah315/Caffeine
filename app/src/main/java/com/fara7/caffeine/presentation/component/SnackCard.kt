package com.fara7.caffeine.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fara7.caffeine.presentation.theme.Black12
import com.fara7.caffeine.presentation.theme.LightGray7
import com.fara7.caffeine.presentation.utils.Distances.spacing70
import com.fara7.caffeine.presentation.utils.Distances.spacing8
import com.fara7.caffeine.presentation.utils.modifier.dropShadow

@Composable
fun SnackCard(image: Int, index: Int, onClick: (Int) -> Unit) {

    Box(
        modifier = Modifier
            .padding(spacing8)
            .dropShadow(
                color = Black12,
                offsetY = 4.dp,
                blur = 12.dp,
                shape = RoundedCornerShape(24.dp)
            )
            .clip(RoundedCornerShape(24.dp))
            .clickable { onClick(image) }
            .background(LightGray7)
            .padding(spacing70),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription ="",
        )
    }
}

