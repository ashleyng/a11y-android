package com.ngashley.a11y.listItems

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.ngashley.a11y.R
import com.ngashley.a11y.common.ResId

enum class ListListItem: ListRow {
    Reorderable,
    Carousel,
    Collection;

    override val titleString: ResId
        get() {
            return when (this) {
                Reorderable -> R.string.reorderable
                Carousel -> R.string.carousel
                Collection -> R.string.collection
            }
        }

    override val subtitleString: ResId?
        get() {
            return when (this) {
                Reorderable -> R.string.reorderable_custom_implementation
                Carousel, Collection -> null
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

    @Composable
    fun DestinationView(navController: NavController) {
        when (this) {
            Reorderable -> "reorderable"
            Carousel -> Carousel()
            Collection -> "collection"
        }
    }
}