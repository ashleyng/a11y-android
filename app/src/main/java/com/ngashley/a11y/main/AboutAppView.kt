package com.ngashley.a11y.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ngashley.a11y.R

@Composable
fun AboutAppView() {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .verticalScroll(rememberScrollState()) ,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = stringResource(id = R.string.about),
            style = MaterialTheme.typography.headlineLarge
        )

        Text(text = stringResource(id = R.string.about_app1))
        Text(text = stringResource(id = R.string.about_app2))
        Text(text = stringResource(id = R.string.about_app3))
        Text(text = stringResource(id = R.string.about_app4))
    }
}

@Composable
fun SettingsAndShortcuts() {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .verticalScroll(rememberScrollState()) ,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = stringResource(id = R.string.settings_shortcuts),
            style = MaterialTheme.typography.headlineLarge
        )
        Text(text = stringResource(id = R.string.shortcuts1))
        Text(text = stringResource(id = R.string.shortcuts2))
        Text(text = stringResource(id = R.string.shortcuts3))

        Column {
            Text(
                text = stringResource(id = R.string.shortcuts_title),
                style =  MaterialTheme.typography.headlineLarge
            )

            Text(text = stringResource(id = R.string.shortcuts4))
        }

        Column {
            Text(
                text = stringResource(id = R.string.accessibility_scanner_title),
                style =  MaterialTheme.typography.headlineLarge
            )
            Text(text = stringResource(id = R.string.shortcuts5))
        }

        Column {
            Text(
                text = stringResource(id = R.string.remove_animation_title),
                style =  MaterialTheme.typography.headlineLarge
            )
            Text(text = stringResource(id = R.string.shortcuts6))
        }
    }
}