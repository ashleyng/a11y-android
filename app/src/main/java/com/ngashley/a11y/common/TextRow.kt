package com.ngashley.a11y.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp

@Composable
fun TitleSubtitle(title: String, subtitle: String?, modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .semantics(mergeDescendants = true) { }
        .padding(16.dp)) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            style = MaterialTheme.typography.titleLarge,
            text = title)
        subtitle?.let {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                style = MaterialTheme.typography.titleSmall,
                text = subtitle
            )
        }
    }

}