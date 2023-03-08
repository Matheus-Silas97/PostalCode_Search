package com.matheussilas97.uikit.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.matheussilas97.common.R

@Composable
fun ErrorDialog(throwable: Throwable?, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = { },
        title = { Text(text = stringResource(R.string.error)) },
        text = {
            Text(
                text = throwable?.message
                    ?: stringResource(R.string.an_unexpected_error_has_occurred)
            )
        },
        confirmButton = {
            Button(
                onClick = { onDismiss.invoke() },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White,
                    contentColor = Color.Black
                )
            ) {
                Text(text = stringResource(R.string.ok))
            }
        })
}

@Composable
@Preview
fun Abc() {
    ErrorDialog(throwable = null, onDismiss = {})
}