package com.ngashley.a11y.listItems

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.ngashley.a11y.common.CommonList
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

    override val titleString: String
        get() {
            return when (this) {
                Button -> "Button"
                Card -> "Card"
                Chip -> "Chip"
                Dialog -> "Dialog"
                ProgressIndicator -> "Progress Indicator"
                Slider -> "Slider"
                Switch -> "Switch"
                BottomSheet -> "Bottom Sheet"
            }
        }

    override val destinationKey: String
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

