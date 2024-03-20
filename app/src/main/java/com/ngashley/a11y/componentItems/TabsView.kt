package com.ngashley.a11y.componentItems

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ngashley.a11y.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TabsView(modifier: Modifier = Modifier) {
    var state1 by remember { mutableStateOf(0) }
    var state2 by remember { mutableStateOf(0) }
    var state3 by remember { mutableStateOf(0) }
    val titles = listOf("Tab 1", "Tab 2", "Tab 3 with lots of text")
    val alotOfTitles = listOf("Tab 1", "Tab 2", "Tab 3 with lots of text", "Tab 4", "Tab 5", "Tab 6", "Tab 7")


    Column(modifier = modifier
        .verticalScroll(rememberScrollState())
        .padding(16.dp)
        .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(32.dp)) {

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = stringResource(id = R.string.primary_tab))
            PrimaryTabRow(selectedTabIndex = state1) {
                titles.forEachIndexed { index, title ->
                    Tab(
                        selected = state1 == index,
                        onClick = { state1 = index },
                        text = { Text(text = title) }
                    )
                }
            }
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = stringResource(id = R.string.secondary_tab))
            SecondaryTabRow(selectedTabIndex = state2) {
                titles.forEachIndexed { index, title ->
                    Tab(
                        selected = (index == state2),
                        onClick = { state2 = index },
                        text = { Text(title) }
                    )
                }
            }
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = stringResource(id = R.string.scrollable_tab))
            ScrollableTabRow(selectedTabIndex = state3) {
                alotOfTitles.forEachIndexed { index, title ->
                    Tab(
                        selected = (index == state3),
                        onClick = { state3 = index },
                        text = { Text(title) }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun TabsPreview() {
    TabsView()
}