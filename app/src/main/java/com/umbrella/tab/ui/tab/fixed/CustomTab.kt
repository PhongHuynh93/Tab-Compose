package com.umbrella.tab.ui.tab.fixed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomTab() {
    var tabIndex by remember { mutableStateOf(0) }
    val tabData = listOf(
        "MUSIC",
        "MARKET",
        "FILMS",
        "BOOKS",
    )
    TabRow(selectedTabIndex = tabIndex) {
        tabData.forEachIndexed { index, text ->
            val selected = tabIndex == index

            Tab(selected = selected, onClick = {
                tabIndex = index
            }) {
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .height(50.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        Modifier
                            .size(24.dp)
                            .align(Alignment.CenterHorizontally)
                            .background(color = if (selected) Color.Red else Color.White)
                    )
                    Text(
                        text = text,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CustomTabPreview() {
    CustomTab()
}