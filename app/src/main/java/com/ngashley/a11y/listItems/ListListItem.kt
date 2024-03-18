package com.ngashley.a11y.listItems

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.ngashley.a11y.R
import com.ngashley.a11y.common.ResId
import com.ngashley.a11y.main.ListRow

enum class ListListItem: ListRow {
    Reorderable,
    Carousel,
    Collection;

    override val subtitleString: ResId?
        get() {
            return when (this) {
                Reorderable -> R.string.reorderable_custom_implementation
                Carousel -> R.string.carousel_page_implementation
                Collection -> null
            }
        }

    override val destinationKey: String?
        get() {
            return when (this) {
                Reorderable -> null
                Carousel -> "carousel"
                Collection -> "collection"
            }
        }

    override fun titleString(context: Context): String {
        return when (this) {
            Reorderable -> context.getString(R.string.reorderable)
            Carousel -> context.getString(R.string.carousel)
            Collection -> context.getString(R.string.collection)
        }
    }

    @Composable
    fun DestinationView(navController: NavController) {
        when (this) {
            Reorderable -> "reorderable"
            Carousel -> Carousel()
            Collection -> "collection"
        }
    }
}