package com.ngashley.a11y.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ngashley.a11y.main.ListRow

@Composable
inline fun <reified P: ListRow> ListItem(navController: NavController, item: P, modifier: Modifier = Modifier) {
    val context = LocalContext.current

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

@Composable
fun TitleSubtitle(title: String, subtitle: String?, modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .semantics(mergeDescendants = true) { }
        .padding(8.dp)) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            style = MaterialTheme.typography.titleMedium,
            text = title)
        subtitle?.let {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                style = MaterialTheme.typography.labelMedium,
                text = subtitle
            )
        }
    }

}