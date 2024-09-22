package com.ngashley.a11y.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ngashley.a11y.common.ListHeader
import com.ngashley.a11y.common.ListItem
import com.ngashley.a11y.componentItems.ComponentItem
import com.ngashley.a11y.fontsAndStrings.FontsAndStringsListItem
import com.ngashley.a11y.listItems.ListListItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    innerPadding: PaddingValues,
    navController: NavHostController,
    startDestination: String = "main",
) {
    val context = LocalContext.current
    NavHost(
        modifier = modifier
            .padding(innerPadding),
        navController = navController,
        startDestination = startDestination
    ) {
        // MAIN LIST
        composable("main") {
            LazyColumn {
                MainListItem.entries.forEach { mainList ->
                    stickyHeader {
                        ListHeader(string = mainList.titleString(context))
                    }

                   items(mainList.items(context)) { item ->
                        ListItem(navController = navController, item = item)
                    }
                }
            }
        }

        AboutMenuItem.entries.forEach { item ->
            item.destinationKey?.let {
                composable(it) {
                    item.DestinationView(navController = navController)
                }
            }
        }

        // LISTS
        ListListItem.entries.forEach { item ->
            item.destinationKey?.let {
                composable(it) {
                    item.DestinationView(navController = navController)
                }
            }
        }
        
        ComponentItem.entries.forEach { item ->
            item.destinationKey?.let {
                composable(it) {
                    item.DestinationView(navController = navController)
                }
            }
        }

        FontsAndStringsListItem.entries.forEach { item ->
            item.destinationKey?.let {
                composable(it) {
                    item.DestinationView(navController = navController)
                }
            }
        }
    }
}