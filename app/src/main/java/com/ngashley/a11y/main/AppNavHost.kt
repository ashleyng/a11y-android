package com.ngashley.a11y.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ngashley.a11y.common.CommonList
import com.ngashley.a11y.listItems.MainListItem

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = "main",
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        // MAIN LIST
        composable("main") {
            CommonList(items = MainListItem.entries, navController = navController)
        }
        MainListItem.entries.forEach { item ->
            composable(item.destinationKey) {
                item.DestinationView(navController = navController)
            }
        }


    }
}