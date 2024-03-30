package com.ngashley.a11y.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.ngashley.a11y.R

@Composable
fun MoreMenuDropDownMenu(navController: NavController) {
    var dropDownMenuExpanded by remember { mutableStateOf(false) }
    val context = LocalContext.current

    IconButton(onClick = {
        dropDownMenuExpanded = true
    }) {
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "Localized description"
        )
    }

    DropdownMenu(
        expanded = dropDownMenuExpanded,
        onDismissRequest = { dropDownMenuExpanded = false }
    ) {
        AboutMenuItem.entries.forEach { item ->
            DropdownMenuItem(text = { Text(text = item.titleString(context = context)) },
                onClick = {
                    item.destinationKey?.let {
                        dropDownMenuExpanded = false
                        navController.navigate(it)
                    }
                })
        }
    }
}