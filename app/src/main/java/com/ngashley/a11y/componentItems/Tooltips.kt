package com.ngashley.a11y.componentItems

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.RichTooltip
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ngashley.a11y.R
import com.ngashley.a11y.common.shortLoremIpsum
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolTipsView(modifier: Modifier = Modifier) {
    val tooltipPlainState = rememberTooltipState()
    val tooltipRichPersistentState = rememberTooltipState(isPersistent = true)
    val scope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(stringResource(R.string.tooltip_description1))
            Text(stringResource(R.string.tooltip_description2))
        }
        TooltipBox(
            positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
            tooltip = {
                PlainTooltip(caretSize = TooltipDefaults.caretSize) {
                    Text(String.shortLoremIpsum())
                }
            },
            state = tooltipPlainState
        ) {
            OutlinedButton(onClick = {
                scope.launch {
                    tooltipPlainState.show()
                }
            }) {
                Text(stringResource(R.string.show_plain_tooltip))
            }
        }

        TooltipBox(
            positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
            tooltip = {
                RichTooltip(
                    title = {
                        Text( stringResource(R.string.rich_tooltip_title))
                    },
                    action = {
                        TextButton(onClick = {
                            scope.launch {
                                tooltipRichPersistentState.dismiss()
                            }
                        }) {
                            Text(stringResource(R.string.dismiss_tooltip))
                        }
                    }
                ) {
                    Text(String.shortLoremIpsum())
                }
            },
            state = tooltipRichPersistentState
        ) {
            OutlinedButton(onClick = {
                scope.launch {
                    tooltipRichPersistentState.show()
                }
            }) {
                Text(stringResource(R.string.show_rich_tooltip))
            }
        }
    }
}

@Preview
@Composable
private fun ToolTipPreview() {
    ToolTipsView()
}