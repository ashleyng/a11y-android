package com.ngashley.a11y.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ngashley.a11y.common.CommonList
import com.ngashley.a11y.componentItems.ComponentItem
import com.ngashley.a11y.listItems.ListListItem

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
            CommonList(
                items = MainListItem.entries.sortedBy { it.titleString(context = context) },
                navController = navController)
        }
        MainListItem.entries.forEach { item ->
            composable(item.destinationKey) {
                item.DestinationView(navController = navController)
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


    }
}