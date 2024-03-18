package com.ngashley.a11y.componentItems

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ngashley.a11y.R

@Composable
fun ButtonView(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .verticalScroll(rememberScrollState())
        .padding(16.dp)
        .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Button(onClick = {  }) {
            Text(stringResource(id = R.string.filled_button))
        }

        TextButton(
            onClick = { }
        ) {
            Text("Text Button")
        }

        Button(onClick = {  },
            enabled = false) {
            Text("Disabled Filled")
        }

        Button(onClick = {  }) {
            Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum dapibus.")
        }

        Column {
            Button(onClick = {  }) {
                Icon(imageVector = Icons.Outlined.Favorite, contentDescription = "")
            }
            Text(text = stringResource(id = R.string.image_button))
        }

        Button(onClick = {  },
            enabled = false) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Icon(imageVector = Icons.Outlined.Favorite, contentDescription = "Heart Icon")
                Text(text = "Disabled")
            }
        }
    }
}

@Preview
@Composable
private fun ButtonPreview() {
    ButtonView()
}