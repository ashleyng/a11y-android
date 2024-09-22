package com.ngashley.a11y.fontsAndStrings

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.ngashley.a11y.R
import com.ngashley.a11y.common.ResId
import com.ngashley.a11y.main.ListRow

enum class FontsAndStringsListItem: ListRow {
    Fonts;

    override val subtitleString: ResId?
        get() = null

    override val destinationKey: String?
        get() {
            return when(this) {
                Fonts -> "fonts"
            }
        }

    override fun titleString(context: Context): String {
        return when(this) {
            Fonts -> context.getString(R.string.font_sizes)
        }
    }

    @Composable
    fun DestinationView(navController: NavController) {
        when (this) {
            Fonts -> {
                FontSizesView()
            }
        }
    }
}