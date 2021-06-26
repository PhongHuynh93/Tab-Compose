package com.umbrella.tab.ui.tab.fixed

import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TextTab() {
    var tabIndex by remember { mutableStateOf(0) }
    val tabData = listOf(
        "MUSIC",
        "MARKET",
        "FILMS",
        "BOOKS",
    )
    TabRow(selectedTabIndex = tabIndex) {
        tabData.forEachIndexed { index, text ->
            Tab(selected = tabIndex == index, onClick = {
                tabIndex = index
            }, text = {
                Text(text = text)
            })
        }
    }
}

@Preview
@Composable
fun TextTabPreview() {
    TextTab()
}