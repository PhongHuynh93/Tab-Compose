package com.umbrella.tab.ui.tab.fixed

import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CombinedTab() {
    var tabIndex by remember { mutableStateOf(0) }
    val tabData = listOf(
        "MUSIC" to Icons.Filled.Home,
        "MARKET" to Icons.Filled.ShoppingCart,
        "FILMS" to Icons.Filled.AccountBox,
        "BOOKS" to Icons.Filled.Settings,
    )
    TabRow(selectedTabIndex = tabIndex) {
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

@Preview
@Composable
fun CombinedTabPreview() {
    CombinedTab()
}