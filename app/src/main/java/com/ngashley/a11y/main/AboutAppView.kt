package com.ngashley.a11y.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.ngashley.a11y.R

@Composable
fun AboutAppView() {
    val annotatedStringTag = "github_tag"

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
        val annotatedString = buildAnnotatedString {
            val string = String.format(stringResource(id = R.string.app_on_github), "A11y Example", "GitHub")
            pushStringAnnotation(tag = annotatedStringTag, annotation = "https://github.com/ashleyng/a11y-android")
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                append(string)
            }
        }
        val uriHandler = LocalUriHandler.current
        ClickableText(
            text = annotatedString) { offset ->
            annotatedString.getStringAnnotations(tag = annotatedStringTag, start = offset, end = offset).firstOrNull()?.let {
                uriHandler.openUri(it.item)
            }
        }
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