package com.ngashley.a11y.componentItems

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ngashley.a11y.R
import com.ngashley.a11y.common.ResId

@Composable
fun ChipView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState()) ,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = stringResource(id = R.string.scrollable_chips))
            ScrollFilterChipView()
        }

        HorizontalDivider()

        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = stringResource(id = R.string.wrapped_chips))
            FlowFilterChipView()
        }
    }

}

enum class PizzaTopping(val stringResId: ResId) {
    Cheese(R.string.cheese),
    Pepperoni(R.string.pepperoni),
    Peppers(R.string.peppers),
    Pineapple(R.string.pineapple),
    Mushrooms(R.string.mushrooms);
}
private data class FilterChip(val pizzaTopping: PizzaTopping, var selected: Boolean)

@Composable
private fun ScrollFilterChipView() {
    val filterChips = remember {
        mutableStateListOf(
            FilterChip(PizzaTopping.Cheese, false),
            FilterChip(PizzaTopping.Pepperoni, false),
            FilterChip(PizzaTopping.Peppers, false),
            FilterChip(PizzaTopping.Pineapple, false),
            FilterChip(PizzaTopping.Mushrooms, false)
        )
    }

    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        filterChips.forEachIndexed { index, filterChip ->
            val selected = filterChip.selected
            FilterChip(
                onClick = { filterChips[index] = filterChip.copy(selected = !selected) },
                label = {
                    Text(stringResource(id = filterChip.pizzaTopping.stringResId))
                },
                selected = selected,
                leadingIcon = if (selected) {
                    {
                        Icon(
                            imageVector = Icons.Filled.Done,
                            contentDescription = "Done icon",
                            modifier = Modifier.size(FilterChipDefaults.IconSize)
                        )
                    }
                } else {
                    null
                },
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun FlowFilterChipView() {
    val filterChips = remember {
        mutableStateListOf(
            FilterChip(PizzaTopping.Cheese, false),
            FilterChip(PizzaTopping.Pepperoni, false),
            FilterChip(PizzaTopping.Peppers, false),
            FilterChip(PizzaTopping.Pineapple, false),
            FilterChip(PizzaTopping.Mushrooms, false)
        )
    }

    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        filterChips.forEachIndexed { index, filterChip ->
            val selected = filterChip.selected
            FilterChip(
                onClick = { filterChips[index] = filterChip.copy(selected = !selected) },
                label = {
                    Text(stringResource(id = filterChip.pizzaTopping.stringResId))
                },
                selected = selected,
                leadingIcon = if (selected) {
                    {
                        Icon(
                            imageVector = Icons.Filled.Done,
                            contentDescription = null,
                            modifier = Modifier.size(FilterChipDefaults.IconSize)
                        )
                    }
                } else {
                    null
                },
            )
        }
    }
}

@Preview
@Composable
private fun ChipPreview() {
    ChipView()
}