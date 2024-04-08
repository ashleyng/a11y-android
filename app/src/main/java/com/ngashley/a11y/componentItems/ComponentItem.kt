package com.ngashley.a11y.componentItems

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.ngashley.a11y.R
import com.ngashley.a11y.common.ResId
import com.ngashley.a11y.main.ListRow


enum class ComponentItem: ListRow {
    Button,
    Card,
    Chip,
    Dialog,
    //    ProgressIndicator, // TODO: Think through notification completion announcements
    Slider,
    Switch,
    BottomSheet,
    DatePicker,
    Tabs,
    SegmentedButton,
    FloatingActionButton,
    CheckBox;

    override val subtitleString: ResId?
        get() {
            return when (this) {
                DatePicker -> {
                    R.string.date_picker_description
                }
                SegmentedButton -> {
                    R.string.segmented_button_description
                }
                Button, Card, Chip, Dialog, Slider,
                    Switch, BottomSheet, FloatingActionButton, Tabs, CheckBox -> {
                        null
                    }
            }
        }

    override val destinationKey: String?
        get() {
            return when (this) {
                Button -> "button"
                Card -> "card"
                Chip -> "chip"
                Dialog -> "dialog"
//                ProgressIndicator -> null
                Slider -> "slider"
                Switch -> "switch"
                BottomSheet -> "bottomsheet"
                DatePicker -> null
                Tabs -> "tabs"
                SegmentedButton -> null
                FloatingActionButton -> null
                CheckBox -> "checkbox"
            }
        }

    override fun titleString(context: Context): String {
        return when (this) {
            Button -> context.getString(R.string.button)
            Card -> context.getString(R.string.card)
            Chip -> context.getString(R.string.chip)
            Dialog -> context.getString(R.string.dialog_str)
//            ProgressIndicator -> String.format(context.getString(R.string.coming_soon), context.getString(R.string.progress_indicator))
            Slider -> context.getString(R.string.slider)
            Switch -> context.getString(R.string.switch_str)
            BottomSheet -> context.getString(R.string.bottom_sheet)
            DatePicker -> context.getString(R.string.date_picker)
            Tabs -> context.getString(R.string.tabs)
            SegmentedButton -> context.getString(R.string.segmented_button)
            FloatingActionButton -> String.format(context.getString(R.string.coming_soon), context.getString(R.string.floating_action_button))
            CheckBox -> context.getString(R.string.checkbox)
        }
    }

    @Composable
    fun DestinationView(navController: NavController) {
        when (this) {
            Button -> ButtonView()
            Card -> CardView()
            Chip -> ChipView()
            Dialog -> DialogView()
//            ProgressIndicator -> "progressIndicator"
            Slider -> SliderView()
            Switch -> SwitchView()
            BottomSheet -> BottomSheetView()
            DatePicker -> "datePicker"
            Tabs -> TabsView()
            SegmentedButton -> "segmentedButton"
            FloatingActionButton -> "floatingActionButton"
            CheckBox -> CheckboxView()
        }
    }
}

