package com.ngashley.a11y.componentItems

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ngashley.a11y.R
import com.ngashley.a11y.common.Activities
import com.ngashley.a11y.common.PizzaTopping

private data class MultiSelectItem(
    val selected: Boolean,
    val item: Activities
) {
    companion object {
        fun defaultItems(): MutableList<MultiSelectItem> {
            return Activities.entries.map {
                MultiSelectItem(selected = false, it)
            }.toMutableStateList()
        }
    }
}

@Composable
fun SegmentedButtonView(modifier: Modifier = Modifier) {
    val singleSelectItemList: List<PizzaTopping> =
        listOf(PizzaTopping.Pineapple, PizzaTopping.Cheese, PizzaTopping.Pepperoni)
    var singleSelectedIndex by remember { mutableIntStateOf(0) }

    val scrollableSingleSelectItemList = PizzaTopping.entries
    var scrollableSingleSelectIndex by remember { mutableIntStateOf(0) }


    val multiSelectItemList = remember {
        MultiSelectItem.defaultItems()
    }

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Text(stringResource(R.string.segmented_button_description1))
        Text(stringResource(R.string.segmented_button_description2))
        Column {
            Text(
                text = stringResource(R.string.segmented_button_single_select),
                style = MaterialTheme.typography.titleMedium
            )
            SingleChoiceSegmentedButtonRow {
                singleSelectItemList.forEachIndexed { index, item ->
                    SegmentedButton(
                        shape = SegmentedButtonDefaults.itemShape(
                            index = index,
                            count = singleSelectItemList.size
                        ),
                        onClick = { singleSelectedIndex = index },
                        selected = index == singleSelectedIndex,
                        label = {
                            Text(stringResource(item.stringResId))
                        }
                    )
                }
            }
        }

        Column {
            Text(
                text = stringResource(R.string.scrollable_segmented_button_single_select),
                style = MaterialTheme.typography.titleMedium
            )
            Text(stringResource(R.string.scrollable_segmented_button_issue))
                SingleChoiceSegmentedButtonRow(
                    modifier = Modifier
                        .horizontalScroll(rememberScrollState())
                ) {
                    scrollableSingleSelectItemList.forEachIndexed { index, item ->
                        SegmentedButton(
                            shape = SegmentedButtonDefaults.itemShape(
                                index = index,
                                count = singleSelectItemList.size
                            ),
                            onClick = { scrollableSingleSelectIndex = index },
                            selected = index == scrollableSingleSelectIndex,
                            label = {
                                Text(stringResource(item.stringResId))
                            }
                        )
                    }
                }
        }

        Column {
            Text(
                text = stringResource(R.string.segmented_button_multiselect),
                style = MaterialTheme.typography.titleMedium
            )
            MultiChoiceSegmentedButtonRow {
                multiSelectItemList.forEachIndexed { index, item ->
                    SegmentedButton(
                        shape = SegmentedButtonDefaults.itemShape(
                            index = index,
                            count = multiSelectItemList.size
                        ),
                        checked = multiSelectItemList[index].selected,
                        onCheckedChange = {
                            val selectedItem = multiSelectItemList[index]
                            multiSelectItemList[index] =
                                selectedItem.copy(selected = !selectedItem.selected)
                        },
                        icon = {
                            SegmentedButtonDefaults.Icon(multiSelectItemList[index].selected)
                        },
                        label = {
                            Icon(
                                painter =
                                    painterResource(item.item.iconRes),
                                contentDescription = stringResource(item.item.stringKey)
                            )
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun SegmentedButtonPreview() {
    SegmentedButtonView()
}