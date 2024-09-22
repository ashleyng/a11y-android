package com.ngashley.a11y.componentItems

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ngashley.a11y.R

@Composable
fun SwitchView(modifier: Modifier = Modifier) {
    var checked1 by remember { mutableStateOf(true) }
    var checked2 by remember { mutableStateOf(false) }
    var checked3 by remember { mutableStateOf(true) }
    val (checked4, onChecked4) = remember { mutableStateOf(false) }

    Column(modifier = modifier
        .verticalScroll(rememberScrollState())
        .padding(16.dp)
        .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)) {

        Switch(
            checked = checked1,
            onCheckedChange = {
                checked1 = it
            }
        )

        Switch(
            checked = checked2,
            onCheckedChange = {
                checked2 = it
            },
            thumbContent = if (checked2) {
                {
                    Icon(
                        imageVector = Icons.Filled.Check,
                        contentDescription = null,
                        modifier = Modifier.size(SwitchDefaults.IconSize),
                    )
                }
            } else {
                null
            }
        )

        Switch(
            checked = checked3,
            enabled = false,
            onCheckedChange = {
                checked3 = it
            }
        )

        HorizontalDivider()
        
        Text(
            text = stringResource(id = R.string.switch_modifier)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .toggleable(
                    value = checked4,
                    onValueChange = { onChecked4(!checked4) },
                    role = Role.Switch
                )
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.heat_pizza)
            )
            Spacer(modifier = Modifier.weight(1f))
            Switch(
                checked = checked4,
                onCheckedChange = null
            )
        }
    }
}

@Preview
@Composable
private fun SwitchPreview() {
    SwitchView()
}