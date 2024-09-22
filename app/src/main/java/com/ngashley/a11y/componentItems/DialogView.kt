package com.ngashley.a11y.componentItems

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.invisibleToUser
import androidx.compose.ui.semantics.semantics
import com.ngashley.a11y.R
import com.ngashley.a11y.common.shortLoremIpsum


@Composable
fun DialogView() {
    var showAlert by remember { mutableStateOf(false) }

    Button(onClick = {
        showAlert = true
    }) {
        Text(stringResource(id = R.string.show_alert_dialog))
    }

    if (showAlert) {
        TextButtonDialog(
            onDismiss = {
                showAlert = false
            },
            onConfirm = {
                showAlert = false
            }
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun TextButtonDialog(onDismiss: () -> Unit, onConfirm: () -> Unit) {

    AlertDialog(
        icon = {
            // Completely decorative item
            Icon(
                modifier = Modifier
                    .semantics {
                           invisibleToUser()
                    },
                imageVector = Icons.Default.Info,
                contentDescription = null)

        },
        title = {
            Text(text = stringResource(id = R.string.alert_dialog_example))
        },
        text = {
            Text(text = String.shortLoremIpsum())
        },
        onDismissRequest = {
            onDismiss()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirm()
                }
            ) {
                Text(text = stringResource(id = R.string.alert_confirm))
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismiss()
                }
            ) {
                Text(text = stringResource(id = R.string.alert_dismiss))
            }
        }
    )
}