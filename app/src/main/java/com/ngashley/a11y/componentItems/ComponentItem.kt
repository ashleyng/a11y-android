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
    ProgressIndicator,
    Slider,
    Switch,
    BottomSheet;

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

    override fun titleString(context: Context): String {
        return when (this) {
            Button -> context.getString(R.string.button)
            Card -> String.format(context.getString(R.string.coming_soon), context.getString(R.string.card))
            Chip -> String.format(context.getString(R.string.coming_soon), context.getString(R.string.chip))
            Dialog -> String.format(context.getString(R.string.coming_soon), context.getString(R.string.dialog_str))
            ProgressIndicator -> String.format(context.getString(R.string.coming_soon), context.getString(R.string.progress_indicator))
            Slider -> String.format(context.getString(R.string.coming_soon), context.getString(R.string.slider))
            Switch -> String.format(context.getString(R.string.coming_soon), context.getString(R.string.switch_str))
            BottomSheet -> String.format(context.getString(R.string.coming_soon), context.getString(R.string.bottom_sheet))
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

