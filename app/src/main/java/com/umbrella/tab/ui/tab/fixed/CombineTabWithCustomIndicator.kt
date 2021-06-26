package com.umbrella.tab.ui.tab.fixed

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CombinedTabWithCustomIndicator() {
    var tabIndex by remember { mutableStateOf(0) }
    val tabData = listOf(
        "MUSIC" to Icons.Filled.Home,
        "MARKET" to Icons.Filled.ShoppingCart,
        "FILMS" to Icons.Filled.AccountBox,
        "BOOKS" to Icons.Filled.Settings,
    )
    TabRow(
        selectedTabIndex = tabIndex,
        backgroundColor = Color.Yellow,
        contentColor = Color.Black,
        divider = {
            TabRowDefaults.Divider(
                thickness = 5.dp,
                color = Color.Blue
            )
        },
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.customTabIndicatorOffset(tabPositions[tabIndex]),
                height = 5.dp,
                color = Color.Green
            )
        }
    ) {
        tabData.forEachIndexed { index, pair ->
            Tab(selected = tabIndex == index, onClick = {
                tabIndex = index
            }, text = {
                Text(text = pair.first)
            }, icon = {
                Icon(imageVector = pair.second, contentDescription = null)
            })
        }
    }
}

fun Modifier.customTabIndicatorOffset(
    currentTabPosition: TabPosition
): Modifier = composed(
    inspectorInfo = debugInspectorInfo {
        name = "tabIndicatorOffset"
        value = currentTabPosition
    }
) {
    val indicatorWidth = 32.dp
    val currentTabWidth = currentTabPosition.width
    val indicatorOffset by animateDpAsState(
        targetValue = currentTabPosition.left + currentTabWidth / 2 - indicatorWidth / 2,
        animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing)
    )
    fillMaxWidth()
        .wrapContentSize(Alignment.BottomStart)
        .offset(x = indicatorOffset)
        .width(indicatorWidth)
}

@Preview
@Composable
fun CombinedTabWithCustomIndicatorPreview() {
    CombinedTabWithCustomIndicator()
}