package com.ngashley.a11y.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TextRow(text: String, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        text = text)
}