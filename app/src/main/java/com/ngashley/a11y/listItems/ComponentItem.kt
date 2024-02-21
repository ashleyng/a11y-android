package com.ngashley.a11y.listItems

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.ngashley.a11y.R
import com.ngashley.a11y.common.CommonList
import com.ngashley.a11y.common.ResId
import com.ngashley.a11y.componentItems.ButtonView


enum class ComponentItem: ListRow {
    Button,
    Card,
    Chip,
    Dialog,
    ProgressIndicator,
    Slider,
    Switch,
    BottomSheet;

    override val titleString: ResId
        get() {
            return when (this) {
                Button -> R.string.button
                Card -> R.string.card
                Chip -> R.string.chip
                Dialog -> R.string.dialog_str
                ProgressIndicator -> R.string.progress_indicator
                Slider -> R.string.slider
                Switch -> R.string.switch_str
                BottomSheet -> R.string.bottom_sheet
            }
        }

    override val subtitleString: ResId?
        get() = null

    override val destinationKey: String?
        get() {
            return when (this) {
                Button -> "button"
                Card -> "card"
                Chip -> "chip"
                Dialog -> "dialog"
                ProgressIndicator -> "progressIndicator"
                Slider -> "slider"
                Switch -> "switch"
                BottomSheet -> "bottomSheet"
            }
        }

    @Composable
    fun DestinationView(navController: NavController) {
        when (this) {
            Button -> ButtonView()
            Card -> "card"
            Chip -> "chip"
            Dialog -> "dialog"
            ProgressIndicator -> "progressIndicator"
            Slider -> "slider"
            Switch -> "switch"
            BottomSheet -> "bottomSheet"
        }
    }
}

