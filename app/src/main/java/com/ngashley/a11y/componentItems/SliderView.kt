package com.ngashley.a11y.componentItems

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SliderView(modifier: Modifier = Modifier) {
    var sliderPosition1 by remember { mutableFloatStateOf(0f) }
    var sliderPosition2 by remember { mutableFloatStateOf(20f) }
    var rangePosition by remember { mutableStateOf(-100f..100f) }


    Column(modifier = modifier
        .verticalScroll(rememberScrollState())
        .padding(16.dp)
        .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)) {

        Slider(
            value = sliderPosition1,
            onValueChange = { sliderPosition1 = it }
        )

        Slider(
            value = sliderPosition2,
            onValueChange = {sliderPosition2 = it},
            steps = 5,
            valueRange = 0f..100f
        )

        RangeSlider(
            value = rangePosition,
            steps = 5,
            onValueChange = { range -> rangePosition = range },
            valueRange = -100f..100f,
            onValueChangeFinished = { },
        )
    }
}

@Preview
@Composable
private fun SliderPreview() {
    SliderView()
}