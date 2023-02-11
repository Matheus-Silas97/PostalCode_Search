package com.matheussilas97.uikit.components

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ActionButton(text: String, click: () -> Unit, modifier: Modifier = Modifier) {
    Button(onClick = click, modifier = modifier) {
        Text(text = text)
    }
}

@Preview
@Composable
fun ButtonPreview() {
    ActionButton(text = "Ação", modifier = Modifier, click = {})
}