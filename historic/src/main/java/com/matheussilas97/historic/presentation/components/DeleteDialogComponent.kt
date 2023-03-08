package com.matheussilas97.historic.presentation.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import com.matheussilas97.historic.R

@Composable
fun DeleteDialogComponent(delete: () -> Unit) {

    var isOpen by remember {
        mutableStateOf(true)
    }

    if (isOpen) {
        AlertDialog(
            onDismissRequest = { isOpen = false },
            title = { Text(text = stringResource(R.string.delete_address_title)) },
            text = { Text(text = stringResource(R.string.delete_address_message)) },
            confirmButton = {
                Button(
                    onClick = { delete.invoke()
                        isOpen = false},
                ) {
                    Text(text = stringResource(R.string.delete))
                }
            },
            dismissButton = {
                Button(onClick = { isOpen = false }) {
                    Text(text = stringResource(R.string.cancel))

                }
            })
    }
}