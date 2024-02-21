package com.ngashley.a11y.common

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.ngashley.a11y.listItems.ListRow

@Composable
inline fun <reified P: ListRow> CommonList(navController: NavController, items: List<P>, modifier: Modifier = Modifier) {

    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        items.forEach { item ->
            TitleSubtitle(
                modifier = Modifier
                    .ifLet(item.destinationKey) { destinationKey ->
                        clickable {
                            navController.navigate(destinationKey)
                        }
                    },
                title = stringResource(id = item.titleString),
                subtitle = item.subtitleString?.let { stringResource(id = it) }
            )
        }
    }
}