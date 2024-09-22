package com.ngashley.a11y.listItems

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.HorizontalUncontainedCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ngashley.a11y.R

data class CarouselItem(
    @DrawableRes val imageResId: Int,
    @StringRes val contentDescription: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarouselView() {
    val items =
        listOf(
            CarouselItem(imageResId = R.drawable.sunset_1, contentDescription = R.string.sunset_1_content_description),
            CarouselItem(imageResId = R.drawable.sunset_2, contentDescription = R.string.sunset_2_content_description),
            CarouselItem(imageResId = R.drawable.sunset_3, contentDescription = R.string.sunset_3_content_description),
            CarouselItem(imageResId = R.drawable.sunset_4, contentDescription = R.string.sunset_4_content_description),
            CarouselItem(imageResId = R.drawable.lilly_flower, contentDescription = R.string.lily_photo_content_description)
        )

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .padding(8.dp)
    ) {
        Text(
            text = stringResource(id = R.string.multibrowser_carousel),
            style = MaterialTheme.typography.titleSmall
        )
        HorizontalMultiBrowseCarousel(
            state = rememberCarouselState { items.count() },
            preferredItemWidth = 200.dp,
            itemSpacing = 8.dp,
        ) { i ->
            val item = items[i]
            Image(
                modifier = Modifier
                    .height(160.dp)
                    .maskClip(MaterialTheme.shapes.extraLarge),
                painter = painterResource(id = item.imageResId),
                contentDescription = stringResource(id = item.contentDescription),
                contentScale = ContentScale.Crop
            )
        }

        Text(
            text = stringResource(id = R.string.uncontained_carousel),
            style = MaterialTheme.typography.titleSmall
        )
        HorizontalUncontainedCarousel(
            state = rememberCarouselState { items.count() },
            itemWidth = 200.dp,
            itemSpacing = 8.dp
        ) { i ->
            val item = items[i]
            Image(
                modifier = Modifier
                    .height(160.dp)
                    .maskClip(MaterialTheme.shapes.extraLarge),
                painter = painterResource(id = item.imageResId),
                contentDescription = stringResource(id = item.contentDescription),
                contentScale = ContentScale.Crop
            )
        }
    }
}