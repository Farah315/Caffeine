package com.fara7.caffeine.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.fara7.caffeine.model.coffeeTypeList
import com.fara7.caffeine.presentation.component.CoffeeItem
import com.fara7.caffeine.presentation.utils.Distances.spacing16

@Composable
fun CoffeeSlider(
    onSelectionChanged: (String) -> Unit
) {
    val config = LocalConfiguration.current
    val screenWidth = config.screenWidthDp.dp
    val paddingValue = screenWidth * 0.25f
    val pagerState = rememberPagerState(pageCount = { coffeeTypeList.size })
    HorizontalPager(
        state = pagerState,
        pageSize = PageSize.Fixed(250.dp),
        pageSpacing = -spacing16,
        contentPadding = PaddingValues(horizontal = paddingValue),
        reverseLayout = true

    ) { page ->
        val isSelected = pagerState.currentPage == page
        val scale = animateFloatAsState(if (isSelected) 1f else 0.6f)
        if (isSelected) {
            onSelectionChanged(coffeeTypeList[page].title)
        }
        Box(
        ) {
            CoffeeItem(
                modifier = Modifier.align(Alignment.BottomCenter),
                coffee = coffeeTypeList[page],
                imageScale = scale.value
            )
        }

    }
}