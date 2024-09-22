package com.ngashley.a11y.main

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.ngashley.a11y.R
import com.ngashley.a11y.common.CommonList
import com.ngashley.a11y.common.ResId
import com.ngashley.a11y.componentItems.ComponentItem
import com.ngashley.a11y.fontsAndStrings.FontsAndStringsListItem
import com.ngashley.a11y.listItems.ListListItem

interface ListRow {
    val subtitleString: ResId?
    val destinationKey: String?

    fun titleString(context: Context): String
}

enum class MainListItem : ListRow {
    Lists,
    Components,
    FontsStrings;

    override val subtitleString: ResId?
        get() = null

    override val destinationKey: String
        get() {
            return when (this) {
                Lists -> "lists"
                Components -> "components"
                FontsStrings -> "strings"
            }
        }

    fun items(context: Context): List<ListRow> {
        return when (this) {
            Lists -> ListListItem.entries.sortedBy {
                it.titleString(context = context)
            }

            Components -> ComponentItem.entries.sortedBy { it.titleString(context = context) }
            FontsStrings -> FontsAndStringsListItem.entries
        }
    }

    override fun titleString(context: Context): String {
        return when (this) {
            Lists -> context.getString(R.string.lists)
            Components -> context.getString(R.string.components)
            FontsStrings -> context.getString(R.string.fonts_string_title)
        }
    }
}