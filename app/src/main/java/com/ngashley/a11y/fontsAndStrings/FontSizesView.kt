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
            DisplayLarge -> "Display Large"
            DisplayMedium -> "Display Medium"
            DisplaySmall -> "Display Small"
            HeadlineLarge -> "Headline Large"
            HeadlineMedium -> "Headline Medium"
            HeadlineSmall -> "Headline Small"
            TitleLarge -> "Title Large"
            TitleMedium -> "Title Medium"
            TitleSmall -> "Title Small"
            BodyLarge -> "Body Large"
            BodyMedium -> "Body Medium"
            BodySmall -> "Body Small"
            LabelLarge -> "Label Large"
            LabelMedium -> "Label Medium"
            LabelSmall -> "Label Small"
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