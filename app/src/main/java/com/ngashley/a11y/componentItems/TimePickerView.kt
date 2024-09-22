package com.ngashley.a11y.componentItems

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ngashley.a11y.R
import com.ngashley.a11y.common.TitleSubtitle
import java.time.format.DateTimeFormatter
import java.util.Calendar

enum class TimePickerType {
    Dial,
    Input
}

@Composable
fun TimePickerView(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Column {
            // Dial time picker 24h
            DateTimeRow(
                is24Hour = true,
                timePickerType = TimePickerType.Dial,
                title = stringResource(id = R.string.dial_time_picker_24h)
            )

            // Dial time picker AM/PM
            DateTimeRow(
                is24Hour = false,
                timePickerType = TimePickerType.Dial,
                title = stringResource(id = R.string.dial_time_picker_am_pm)
            )

            // Input time picker 24h
            DateTimeRow(
                is24Hour = true,
                timePickerType = TimePickerType.Input,
                title = stringResource(id = R.string.input_time_picker_24h)
            )

            // Input time picker AM/PM
            DateTimeRow(
                is24Hour = false,
                timePickerType = TimePickerType.Input,
                title = stringResource(id = R.string.input_time_picker_am_pm)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DateTimeRow(
    is24Hour: Boolean,
    timePickerType: TimePickerType,
    title: String
) {
    var showPicker by remember { mutableStateOf(false) }
    var timeHour by remember { mutableIntStateOf(0) }
    var timeMin by remember { mutableIntStateOf(0) }

    Column {
        TitleSubtitle(
            modifier = Modifier
                .clickable {
                    showPicker = true
                },
            title = title,
            subtitle = getTimeDisplay(is24Hour = is24Hour, hour = timeHour, min = timeMin)
        )
        if (showPicker) {
            DialTimePicker(
                inputType = timePickerType,
                is24Hour = is24Hour,
                onConfirm = { state ->
                    timeHour = state.hour
                    timeMin = state.minute
                }, onDismiss = {
                    showPicker = false
                })
        }
    }
}

@Composable
private fun getTimeDisplay(is24Hour: Boolean, hour: Int, min: Int): String {
    val formater = DateTimeFormatter.ofPattern("H:m")
    val selectedDateTime = formater.parse("$hour:$min")
    val formatter = if (is24Hour) {
        DateTimeFormatter.ofPattern("hh:mm a")
    } else {
        DateTimeFormatter.ofPattern("HH:mm")
    }
    return stringResource(id = R.string.selected_time, formatter.format(selectedDateTime))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DialTimePicker(
    inputType: TimePickerType,
    is24Hour: Boolean,
    onConfirm: (TimePickerState) -> Unit,
    onDismiss: () -> Unit,
) {
    val currentTime = Calendar.getInstance()

    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = is24Hour,
    )

    TimePickerDialog(
        onDismiss = {
            onDismiss()
        },
        onConfirm = {
            onConfirm(timePickerState)
            onDismiss()
        }
    ) {
        when (inputType) {
            TimePickerType.Dial -> {
                TimePicker(
                    state = timePickerState,
                )
            }
            TimePickerType.Input -> {
                TimeInput(
                    state = timePickerState
                )
            }
        }

    }
}

@Composable
private fun TimePickerDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    content: @Composable () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        dismissButton = {
            TextButton(onClick = { onDismiss() }) {
                Text(stringResource(id = R.string.cancel))
            }
        },
        confirmButton = {
            TextButton(onClick = { onConfirm() }) {
                Text(stringResource(id = R.string.ok))
            }
        },
        text = { content() }
    )
}