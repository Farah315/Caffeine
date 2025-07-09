package com.fara7.caffeine.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fara7.caffeine.R
import com.fara7.caffeine.presentation.theme.NightBlack
import com.fara7.caffeine.presentation.theme.LightGray


@Composable
fun TopHeader(
    modifier: Modifier = Modifier,
    spaceUnderTopHeader: Dp
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = spaceUnderTopHeader)
    )
    {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(shape = CircleShape)
                .clickable {}

        ) {
            Image(
                painter = painterResource(R.drawable.image_coffe_ghost_profile),
                contentDescription = "",
            )
        }
        Spacer(Modifier.weight(1f))
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(shape = CircleShape)
                .clickable {}
                .background(LightGray),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.icon_add),
                contentDescription = "",
                tint = NightBlack,
                modifier = Modifier.size(24.dp)
            )
        }


    }
}