package com.umbrella.tab.ui.tab.fixed

import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun IconTab() {
    var tabIndex by remember { mutableStateOf(0) }
    val tabData = listOf(
        Icons.Filled.Home,
        Icons.Filled.ShoppingCart,
        Icons.Filled.AccountBox,
        Icons.Filled.Settings,
    )
    TabRow(selectedTabIndex = tabIndex) {
        tabData.forEachIndexed { index, icon ->
            Tab(selected = tabIndex == index, onClick = {
                tabIndex = index
            }, icon = {
                Icon(imageVector = icon, contentDescription = null)
            })
        }
    }
}

@Preview
@Composable
fun IconTabPreview() {
    IconTab()
}