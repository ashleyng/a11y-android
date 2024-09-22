package com.ngashley.a11y.main

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.ngashley.a11y.R
import com.ngashley.a11y.common.ResId

enum class AboutMenuItem: ListRow {
    AboutApp,
    SettingsAndShortcuts;

    override val subtitleString: ResId?
        get() {
            return null
        }

    override val destinationKey: String?
        get() {
            return when (this) {
                AboutApp -> "aboutapp"
                SettingsAndShortcuts -> "settingsandshortcuts"
            }
        }

    override fun titleString(context: Context): String {
        return when (this) {
            AboutApp -> context.getString(R.string.about)
            SettingsAndShortcuts -> context.getString(R.string.about_settings_shortcuts)
        }
    }

    @Composable
    fun DestinationView(navController: NavController) {
        when (this) {
            AboutApp -> AboutAppView()
            SettingsAndShortcuts -> SettingsAndShortcuts()
        }
    }
}