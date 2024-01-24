package com.ngashley.a11y.listItems

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.ngashley.a11y.common.CommonList

interface ListRow {
    val titleString: String
    val destinationKey: String
}

enum class MainListItem: ListRow {
    Lists,
    Components,
    Strings;

    override val titleString: String
        get() {
            return when (this) {
                Lists -> "Lists"
                Components -> "Components"
                Strings -> "String"
            }
        }

    override val destinationKey: String
        get() {
            return when (this) {
                Lists -> "lists"
                Components -> "components"
                Strings -> "strings"
            }
        }

    @Composable
    fun DestinationView(navController: NavController) {
        when (this) {
            Lists -> CommonList(items = ListListItem.entries, navController = navController)
            Components -> CommonList(items = ListListItem.entries, navController = navController)
            Strings -> CommonList(items = ListListItem.entries, navController = navController)
        }
    }
}