package com.matheussilas97.historic.presentation.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.matheussilas97.common.R

@Composable
fun DeleteDialogComponent(delete: () -> Unit, onCloseDialog: () -> Unit) {
    AlertDialog(
        onDismissRequest = onCloseDialog,
        title = { Text(text = stringResource(R.string.delete_address_title)) },
        text = { Text(text = stringResource(R.string.delete_address_message)) },
        confirmButton = {
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White,
                    contentColor = Color.Black
                ),
                onClick = {
                    delete()
                    onCloseDialog()
                },
            ) {
                Text(text = stringResource(R.string.delete))
            }
        },
        dismissButton = {
            Button(
                onClick = { onCloseDialog() }, colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White,
                    contentColor = Color.Black
                )
            ) {
                Text(text = stringResource(R.string.cancel))
            }
        })
}