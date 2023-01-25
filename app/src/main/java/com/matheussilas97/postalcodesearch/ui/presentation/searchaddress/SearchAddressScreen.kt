package com.matheussilas97.postalcodesearch.ui.presentation.searchaddress

import androidx.compose.foundation.layout.*
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.matheussilas97.postalcodesearch.components.ActionButton
import com.matheussilas97.postalcodesearch.components.TextNormal

@Composable
fun SearchAddressScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 12.dp)
    ) {
        TextField(value = "Digite um CEP", onValueChange = {})
        Spacer(modifier = Modifier.width(width = 22.dp))
        ActionButton(text = "Pesquisar CEP", click = {})
        TextNormal(text = "", color = Color.Black)
    }
}