package com.ngashley.a11y.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.ngashley.a11y.main.ListRow

@Composable
inline fun <reified P: ListRow> CommonList(navController: NavController, items: List<P>, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        items.forEach { item ->
            TitleSubtitle(
                modifier = Modifier
                    .ifLet(item.destinationKey) { destinationKey ->
                        clickable {
                            navController.navigate(destinationKey)
                        }
                    },
                title = item.titleString(context = context),
                subtitle = item.subtitleString?.let { stringResource(id = it) }
            )
            HorizontalDivider()
        }
    }
}