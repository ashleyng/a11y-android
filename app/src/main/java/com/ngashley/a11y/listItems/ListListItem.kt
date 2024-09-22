package com.ngashley.a11y.listItems

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.ngashley.a11y.R
import com.ngashley.a11y.common.ResId
import com.ngashley.a11y.main.ListRow

enum class ListListItem: ListRow {
    Reorderable,
    HorizontalPager,
    Carousel,
    Collection;

    override val subtitleString: ResId?
        get() {
            return when (this) {
                Reorderable -> R.string.reorderable_custom_implementation
                HorizontalPager, Carousel -> R.string.carousel_page_implementation
                Collection -> null
            }
        }

    override val destinationKey: String?
        get() {
            return when (this) {
                Reorderable -> null
                HorizontalPager -> "horizontalpager"
                Collection -> null
                Carousel -> "carousel"
            }
        }

    override fun titleString(context: Context): String {
        return when (this) {
            Reorderable -> context.getString(R.string.reorderable)
            HorizontalPager -> context.getString(R.string.horizontal_pager_carousel)
            Collection -> String.format(context.getString(R.string.coming_soon), context.getString(R.string.collection))
            Carousel -> context.getString(R.string.carousel)
        }
    }

    @Composable
    fun DestinationView(navController: NavController) {
        when (this) {
            Reorderable -> "reorderable"
            HorizontalPager -> HorizontalPagerView()
            Collection -> "collection"
            Carousel -> CarouselView()
        }
    }
}