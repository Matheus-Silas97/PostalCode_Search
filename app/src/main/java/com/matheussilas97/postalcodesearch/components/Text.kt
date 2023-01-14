package com.matheussilas97.postalcodesearch.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TextNormal(text: String, color: Color) {
    Text(
        text = text,
        color = color,
    )
}

@Preview
@Composable
fun TextNormalPreview() {
    TextNormal(text = "teste", Color.Black)
}