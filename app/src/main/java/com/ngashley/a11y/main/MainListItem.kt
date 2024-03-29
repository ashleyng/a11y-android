package com.ngashley.a11y.main

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.ngashley.a11y.R
import com.ngashley.a11y.common.CommonList
import com.ngashley.a11y.common.ResId
import com.ngashley.a11y.componentItems.ComponentItem
import com.ngashley.a11y.listItems.ListListItem

interface ListRow {
    val subtitleString: ResId?
    val destinationKey: String?

    fun titleString(context: Context): String
}

enum class MainListItem: ListRow {
    Lists,
    Components;
//    Strings;

    override val subtitleString: ResId?
        get() = null

    override val destinationKey: String
        get() {
            return when (this) {
                Lists -> "lists"
                Components -> "components"
//                Strings -> "strings"
            }
        }

    override fun titleString(context: Context): String {
        return when (this) {
            Lists -> context.getString(R.string.lists)
            Components -> context.getString(R.string.components)
//            Strings -> String.format(context.getString(R.string.coming_soon), context.getString(R.string.string))
        }
    }

    @Composable
    fun DestinationView(navController: NavController) {
        when (this) {
            Lists -> CommonList(items = ListListItem.entries, navController = navController)
            Components -> CommonList(items = ComponentItem.entries, navController = navController)
//            Strings -> CommonList(items = ListListItem.entries, navController = navController)
        }
    }
}