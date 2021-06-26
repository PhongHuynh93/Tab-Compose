package com.umbrella.tab.ui.tab.scrollable

import androidx.compose.material.Icon
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.umbrella.tab.ui.theme.TabTheme

@Composable
fun ScrollableTabs() {
    var tabIndex by remember { mutableStateOf(0) }
    val tabData = listOf(
        "MUSIC" to Icons.Filled.Home,
        "MARKET" to Icons.Filled.ShoppingCart,
        "SUPERMARKET" to Icons.Filled.AccountBox,
        "BOOKS" to Icons.Filled.Settings,
        "FILMS" to Icons.Filled.Home,
        "LIBRARY" to Icons.Filled.Call,
    )
    ScrollableTabRow(selectedTabIndex = tabIndex) {
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

@Preview(showBackground = true)
@Composable
fun ScrollableTabsPreview() {
    TabTheme {
        ScrollableTabs()
    }
}