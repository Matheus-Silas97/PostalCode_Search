package com.matheussilas97.uikit.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun ErrorDialog(throwable: Throwable?, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = { },
        title = { Text(text = "Erro") },
        text = { Text(text = throwable?.message ?: "Um erro inesperado aconteceu") },
        confirmButton = {
            Button(
                onClick = { onDismiss.invoke() },
            ) {
                Text(text = "OK")
            }
        })
}