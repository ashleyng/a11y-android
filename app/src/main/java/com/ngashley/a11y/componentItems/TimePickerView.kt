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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerView(modifier: Modifier = Modifier) {
    var showDialTime24hPicker by remember { mutableStateOf(false) }
    var dialTime24Hour by remember { mutableIntStateOf(0) }
    var dialTime24Min by remember { mutableIntStateOf(0) }

    var showDialTimePicker by remember { mutableStateOf(false) }
    var dialTimeHour by remember { mutableIntStateOf(0) }
    var dialTimeMin by remember { mutableIntStateOf(0) }

    var showInputTime24hPicker by remember { mutableStateOf(false) }
    var inputTime24Hour by remember { mutableIntStateOf(0) }
    var inputTime24Min by remember { mutableIntStateOf(0) }

    var showInputTimePicker by remember { mutableStateOf(false) }
    var inputTimeHour by remember { mutableIntStateOf(0) }
    var inputTimeMin by remember { mutableIntStateOf(0) }

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Column {
            // Dial time picker 24h
            TitleSubtitle(
                modifier = Modifier
                    .clickable {
                        showDialTimePicker = true
                    },
                title = stringResource(id = R.string.dial_time_picker_24h),
                subtitle = getTimeDisplay(is24Hour = true, hour = dialTimeHour, min = dialTimeMin)
            )
            if (showDialTimePicker) {
                DialTimePicker(
                    inputType = TimePickerType.Dial,
                    is24Hour = false,
                    onConfirm = { state ->
                        dialTimeHour = state.hour
                        dialTimeMin = state.minute
                    }, onDismiss = {
                        showDialTimePicker = false
                    })
            }

            // Dial time picker AM/PM
            TitleSubtitle(
                modifier = Modifier
                    .clickable {
                        showDialTime24hPicker = true
                    },
                title = stringResource(id = R.string.dial_time_picker_am_pm),
                subtitle = getTimeDisplay(is24Hour = false, hour = dialTime24Hour, min = dialTime24Min)
            )
            if (showDialTime24hPicker) {
                DialTimePicker(
                    inputType = TimePickerType.Dial,
                    is24Hour = true,
                    onConfirm = { state ->
                        dialTime24Hour = state.hour
                        dialTime24Min = state.minute
                    }, onDismiss = {
                        showDialTime24hPicker = false
                    })
            }

            TitleSubtitle(
                modifier = Modifier
                    .clickable {
                        showInputTime24hPicker = true
                    },
                title = stringResource(id = R.string.dial_time_picker_24h),
                subtitle = getTimeDisplay(is24Hour = true, hour = inputTime24Hour, min = inputTime24Min)
            )
            if (showInputTime24hPicker) {
                DialTimePicker(
                    inputType = TimePickerType.Input,
                    is24Hour = true,
                    onConfirm = { state ->
                        inputTime24Hour = state.hour
                        inputTime24Min = state.minute
                    }, onDismiss = {
                        showInputTime24hPicker = false
                    })
            }

            TitleSubtitle(
                modifier = Modifier
                    .clickable {
                        showInputTimePicker = true
                    },
                title = stringResource(id = R.string.dial_time_picker_24h),
                subtitle = getTimeDisplay(is24Hour = true, hour = inputTimeHour, min = inputTimeMin)
            )
            if (showInputTimePicker) {
                DialTimePicker(
                    inputType = TimePickerType.Input,
                    is24Hour = false,
                    onConfirm = { state ->
                        inputTimeHour = state.hour
                        inputTimeMin = state.minute
                    }, onDismiss = {
                        showInputTimePicker = false
                    })
            }

        }
    }
}

enum class TimePickerType {
    Dial,
    Input
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialTimePicker(
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

@Composable
fun TimePickerDialog(
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