package com.fara7.caffeine.presentation.component

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.fara7.caffeine.presentation.utils.Distances.spacing16
import com.fara7.caffeine.presentation.utils.Distances.spacing160
import com.fara7.caffeine.presentation.utils.Distances.spacing60
import com.fara7.caffeine.model.snacksList
import kotlin.math.abs

@SuppressLint("UseOfNonLambdaOffsetOverload")
@Composable
fun SnackSlider(
    onClick: (Int) -> Unit
) {
    val pagerState = rememberPagerState(
        pageCount = { snacksList.size }
    )
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val paddingValue = screenHeight * 0.55f

    VerticalPager(
        state = pagerState,
        pageSize = PageSize.Fixed(350.dp),
        pageSpacing = (-spacing160),
        contentPadding = PaddingValues(bottom = paddingValue, top = 32.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = spacing16),


        ) { page ->
        Box(
            modifier = Modifier
                .padding(start = spacing60)
        ) {
            val pageOffset = (
                    (pagerState.currentPage) + pagerState.currentPageOffsetFraction
                    ).coerceIn(-1f, 1f)

            val scale = 1f - (abs(pageOffset) * 0.1f)

            val animatedScale by animateFloatAsState(scale)

            val isSelected = pagerState.currentPage == page
            val nextSelected = pagerState.currentPage + 1 == page
            val prevSelected = pagerState.currentPage - 1 == page
            val offsetX = animateFloatAsState(
                if (isSelected) -100f
                else if (nextSelected) -170f
                else if (prevSelected) -300f
                else -400f
            )
            val offsetY = animateFloatAsState(
                if (isSelected) 0f
                else if (nextSelected) 40f
                else if (prevSelected) 150f
                else 30f
            )
            val rotation = animateFloatAsState(
                if (isSelected) 1f
                else if (prevSelected) -20f
                else 10f
            )

            Box(
                modifier = Modifier
                    .scale(animatedScale)
                    .offset(x = offsetX.value.dp, y = offsetY.value.dp)
                    .graphicsLayer {
                        rotationZ = rotation.value
                    },
            ) {
                SnackCard(
                    image = snacksList[page],
                    index = page,
                    onClick = onClick
                )
            }
        }
    }
}
