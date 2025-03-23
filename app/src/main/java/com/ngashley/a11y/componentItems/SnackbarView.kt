package com.ngashley.a11y.componentItems

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ngashley.a11y.R
import com.ngashley.a11y.common.shortLoremIpsum
import kotlinx.coroutines.launch
import java.text.NumberFormat


@Composable
fun SnackbarView(modifier: Modifier = Modifier) {

    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val dismissActionSnackbarCount = remember { mutableIntStateOf(0) }
    val intFormater = NumberFormat.getIntegerInstance()

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
//        floatingActionButton = {
//            ExtendedFloatingActionButton(
//                text = { Text("Show snackbar") },
//                icon = { Icon(Icons.Filled.Image, contentDescription = "") },
//                onClick = {
//                    scope.launch {
//                        snackbarHostState.showSnackbar("Snackbar")
//                    }
//                }
//            )
//        }
    ) { contentPadding ->
        Column(
            modifier = modifier
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(stringResource(R.string.snackbar_description1))
                Text(stringResource(R.string.snackbar_description2))
            }
            Button(onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar(String.shortLoremIpsum())
                }
            }) {
                Text(stringResource(R.string.show_plain_snackbar))
            }

            Button(onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar(
                        message = String.shortLoremIpsum(),
                        duration = SnackbarDuration.Long
                    )
                }
            }) {
                Text(stringResource(R.string.show_long_duration_plain_snackbar))
            }

            val context = LocalContext.current
            Button(onClick = {
                scope.launch {
                    val result = snackbarHostState
                        .showSnackbar(
                            message = String.shortLoremIpsum(),
                            actionLabel = context.getString(R.string.dismiss),
                        )
                    when (result) {
                        SnackbarResult.ActionPerformed -> {
                            dismissActionSnackbarCount.intValue += 1
                        }

                        SnackbarResult.Dismissed -> {
                            /* Handle snackbar dismissed */
                        }
                    }
                }
            }) {
                Text(stringResource(R.string.show_action_snackbar))
            }

            Text(stringResource(R.string.dismiss_action_snackbard_count,
                intFormater.format(dismissActionSnackbarCount.intValue)))
        }
    }
}

@Preview
@Composable
private fun SnackbarPreview() {
    SnackbarView()
}
