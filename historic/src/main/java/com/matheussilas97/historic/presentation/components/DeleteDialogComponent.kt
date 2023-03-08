package com.matheussilas97.historic.presentation.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import com.matheussilas97.historic.R

@Composable
fun DeleteDialogComponent(delete: () -> Unit,   onCloseDialog: () -> Unit,) {
        AlertDialog(
            onDismissRequest =  onCloseDialog ,
            title = { Text(text = stringResource(R.string.delete_address_title)) },
            text = { Text(text = stringResource(R.string.delete_address_message)) },
            confirmButton = {
                Button(
                    onClick = {
                        delete()
                        onCloseDialog()
                              },
                ) {
                    Text(text = stringResource(R.string.delete))
                }
            },
            dismissButton = {
                Button(onClick = { onCloseDialog() }) {
                    Text(text = stringResource(R.string.cancel))

                }
            })
}