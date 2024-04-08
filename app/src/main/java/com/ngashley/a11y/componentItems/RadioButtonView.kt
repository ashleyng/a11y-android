package com.ngashley.a11y.componentItems

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ngashley.a11y.R


@Composable
fun RadioButtonView() {
    val itemList: List<PizzaTopping> = PizzaTopping.entries
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(itemList[0]) }

    Column(modifier = Modifier
        .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = stringResource(id = R.string.radio_button_modifier)
        )
        Column {
            itemList.forEach { pizzaTopping ->
                Row(
                    modifier = Modifier
                        .selectableGroup()
                        .fillMaxWidth()
                        .selectable(
                            selected = (pizzaTopping == selectedOption),
                            onClick = { onOptionSelected(pizzaTopping) },
                            role = Role.RadioButton
                        )
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = pizzaTopping == selectedOption,
                        onClick = null, // accessibility is handled by the selectable modifier
                    )
                    Text(
                        text = stringResource(id = pizzaTopping.stringResId),
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }

    }
}

@Preview
@Composable
private fun RadioButtonPreview() {
    RadioButtonView()
}

