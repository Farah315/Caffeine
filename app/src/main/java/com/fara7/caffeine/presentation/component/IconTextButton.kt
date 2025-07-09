package com.fara7.caffeine.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fara7.caffeine.presentation.theme.AlmostOpaqueWhite
import com.fara7.caffeine.presentation.theme.BlackOverlayLight
import com.fara7.caffeine.presentation.theme.Onyx
import com.fara7.caffeine.presentation.theme.TintWhite87
import com.fara7.caffeine.presentation.utils.modifier.dropShadow
import com.fara7.caffeine.presentation.theme.urbanist
import com.fara7.caffeine.presentation.utils.Distances.spacing12
import com.fara7.caffeine.presentation.utils.Distances.spacing24
import com.fara7.caffeine.presentation.utils.Distances.spacing8


@Composable
fun IconTextButton(
    modifier: Modifier = Modifier,
    text: String,
    icon: Painter,
    onClick: () -> Unit = {},
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(Onyx),
        contentPadding = ButtonDefaults.TextButtonWithIconContentPadding,
        modifier = modifier
            .dropShadow(
                blur = 12.dp,
                shape = ButtonDefaults.shape,
                color = BlackOverlayLight,
                offsetY = 6.dp
            )

    ) {
        Row(
            modifier = Modifier.padding(vertical = spacing12, horizontal =spacing24),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = text,
                color = AlmostOpaqueWhite,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = urbanist,
                modifier = Modifier.padding(end = spacing8),
            )
            Icon(
                painter = icon,
                contentDescription = "",
                tint = TintWhite87,
            )
        }

    }
}