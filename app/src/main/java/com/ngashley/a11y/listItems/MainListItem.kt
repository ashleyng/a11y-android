package com.ngashley.a11y.listItems

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.ngashley.a11y.R
import com.ngashley.a11y.common.CommonList
import com.ngashley.a11y.common.ResId

interface ListRow {
    val titleString: ResId
    val subtitleString: ResId?
    val destinationKey: String?
}

enum class MainListItem: ListRow {
    Lists,
    Components,
    Strings;

    override val titleString: ResId
        get() {
            return when (this) {
                Lists -> R.string.lists
                Components -> R.string.components
                Strings -> R.string.string
            }
        }

    override val subtitleString: ResId?
        get() = null

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
            Components -> CommonList(items = ComponentItem.entries, navController = navController)
            Strings -> CommonList(items = ListListItem.entries, navController = navController)
        }
    }
}