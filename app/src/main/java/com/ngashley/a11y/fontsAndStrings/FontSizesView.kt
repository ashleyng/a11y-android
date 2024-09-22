package com.ngashley.a11y.fontsAndStrings

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.ngashley.a11y.R

enum class FontSizeType {
    DisplayLarge,
    DisplayMedium,
    DisplaySmall,
    HeadlineLarge,
    HeadlineMedium,
    HeadlineSmall,
    TitleLarge,
    TitleMedium,
    TitleSmall,
    BodyLarge,
    BodyMedium,
    BodySmall,
    LabelLarge,
    LabelMedium,
    LabelSmall;

    val fontType: TextStyle
        @Composable
        get() {
            return when (this) {
                DisplayLarge -> MaterialTheme.typography.displayLarge
                DisplayMedium -> MaterialTheme.typography.displayMedium
                DisplaySmall -> MaterialTheme.typography.displaySmall
                HeadlineLarge -> MaterialTheme.typography.headlineLarge
                HeadlineMedium -> MaterialTheme.typography.headlineMedium
                HeadlineSmall -> MaterialTheme.typography.headlineSmall
                TitleLarge -> MaterialTheme.typography.titleLarge
                TitleMedium -> MaterialTheme.typography.titleMedium
                TitleSmall -> MaterialTheme.typography.titleSmall
                BodyLarge -> MaterialTheme.typography.bodyLarge
                BodyMedium -> MaterialTheme.typography.bodyMedium
                BodySmall -> MaterialTheme.typography.bodySmall
                LabelLarge -> MaterialTheme.typography.labelLarge
                LabelMedium -> MaterialTheme.typography.labelMedium
                LabelSmall -> MaterialTheme.typography.labelSmall
            }
        }


    fun stringTitle(context: Context): String {
        return when (this) {
            DisplayLarge -> context.getString(R.string.display_large)
            DisplayMedium -> context.getString(R.string.display_medium)
            DisplaySmall -> context.getString(R.string.display_small)
            HeadlineLarge -> context.getString(R.string.headline_large)
            HeadlineMedium -> context.getString(R.string.headline_medium)
            HeadlineSmall -> context.getString(R.string.headline_small)
            TitleLarge -> context.getString(R.string.title_large)
            TitleMedium -> context.getString(R.string.title_medium)
            TitleSmall -> context.getString(R.string.title_small)
            BodyLarge -> context.getString(R.string.body_large)
            BodyMedium -> context.getString(R.string.body_medium)
            BodySmall -> context.getString(R.string.body_small)
            LabelLarge -> context.getString(R.string.label_large)
            LabelMedium -> context.getString(R.string.label_medium)
            LabelSmall -> context.getString(R.string.label_small)
        }
    }
}

@Composable
fun FontSizesView() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState()),
    ) {
        Text(
            modifier = Modifier
                .padding(16.dp),
            text = stringResource(id = R.string.font_size_description)
        )
        FontSizeType.entries.forEach { item ->
            Text(
                modifier = Modifier
                    .padding(16.dp),
                text = item.stringTitle(context = context),
                style = item.fontType
            )
            HorizontalDivider()
        }
    }
}