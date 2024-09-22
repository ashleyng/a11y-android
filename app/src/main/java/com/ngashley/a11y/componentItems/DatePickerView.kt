package com.ngashley.a11y.componentItems

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ngashley.a11y.R
import com.ngashley.a11y.common.TitleSubtitle
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerView(modifier: Modifier = Modifier) {
    var showModalDatePicker by remember { mutableStateOf(false) }
    val modalDatePickerState = rememberDatePickerState()
    val selectedModalDateString = getDateString(millis = modalDatePickerState.selectedDateMillis)

    var showInputDatePicker by remember { mutableStateOf(false) }
    val inputDatePickerState = rememberDatePickerState()
    val inputDateString = getDateString(millis = inputDatePickerState.selectedDateMillis)

    var showRestrictedDatePicker by remember { mutableStateOf(false) }
    val restrictedDatePickerState = rememberDatePickerState()
    val restrictedDateString = getDateString(millis = restrictedDatePickerState.selectedDateMillis)


    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Column {
            // Modal date picker
            TitleSubtitle(
                modifier = Modifier
                    .clickable {
                        showModalDatePicker = true
                    },
                title = stringResource(id = R.string.modal_date_picker),
                subtitle = selectedModalDateString
            )
            if (showModalDatePicker) {
                DatePickerModal(
                    initialDisplayMode = DisplayMode.Picker,
                    selectableDates = DatePickerDefaults.AllDates,
                    onDateSelected = { millis ->
                        modalDatePickerState.selectedDateMillis = millis
                    },
                    onDismiss = {
                        showModalDatePicker = false
                    })
            }

            // Modal input picker
            TitleSubtitle(
                modifier = Modifier
                    .clickable {
                        showInputDatePicker = true
                    },
                title = stringResource(id = R.string.input_modal_date_picker),
                subtitle = inputDateString
            )
            if (showInputDatePicker) {
                DatePickerModal(
                    initialDisplayMode = DisplayMode.Input,
                    selectableDates = DatePickerDefaults.AllDates,
                    onDateSelected = { millis ->
                        inputDatePickerState.selectedDateMillis = millis
                    }, onDismiss = {
                        showInputDatePicker = false
                    })
            }

            // Restricted input picker
            TitleSubtitle(
                modifier = Modifier
                    .clickable {
                        showRestrictedDatePicker = true
                    },
                title = stringResource(id = R.string.restricted_date),
                subtitle = restrictedDateString
            )
            if (showRestrictedDatePicker) {
                DatePickerModal(
                    initialDisplayMode = DisplayMode.Picker,
                    selectableDates = TwoWeekPastSelectableDates,
                    onDateSelected = { millis ->
                        restrictedDatePickerState.selectedDateMillis = millis
                    }, onDismiss = {
                        showRestrictedDatePicker = false
                    })
            }
        }
    }
}

@ExperimentalMaterial3Api
object TwoWeekPastSelectableDates: SelectableDates {
    override fun isSelectableDate(utcTimeMillis: Long): Boolean {
        val days = ChronoUnit.DAYS.between(Instant.ofEpochMilli(utcTimeMillis), Instant.ofEpochMilli(System.currentTimeMillis()))
        return days <= 14
    }

    override fun isSelectableYear(year: Int): Boolean {
        return year <= LocalDate.now().year
    }
}

@Composable
private fun getDateString(millis: Long?): String {
    return millis?.let {
        val formatter = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
        stringResource(id = R.string.selected_date, formatter.format(Date(millis)))
    } ?: run {
        stringResource(id = R.string.no_date_selected)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DatePickerModal(
    initialDisplayMode: DisplayMode,
    selectableDates: SelectableDates,
    onDateSelected: (Long?) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState(
        initialDisplayMode = initialDisplayMode,
        selectableDates = selectableDates
    )

    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = {
                onDateSelected(datePickerState.selectedDateMillis)
                onDismiss()
            }) {
                Text(stringResource(id = R.string.ok))
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(stringResource(id = R.string.cancel))
            }
        }
    ) {
        DatePicker(state = datePickerState)
    }
}
