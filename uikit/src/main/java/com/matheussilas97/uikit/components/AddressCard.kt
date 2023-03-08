package com.matheussilas97.uikit.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matheussilas97.common.entity.AddressEntity

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AddressCard(address: AddressEntity, delete: () -> Unit) {
    Card(
        border = BorderStroke(1.dp, Color.Gray),
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 2.dp),
        onClick = { delete.invoke() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp)
        ) {
            TextNormal(text = "CEP: ${address.postalCode}")
            TextNormal(text = "Logradouro: ${address.street}")
            TextNormal(text = "Complemento: ${address.complement}")
            TextNormal(text = "Bairro: ${address.neighborhood}")
            TextNormal(text = "Cidade: ${address.city}")
            TextNormal(text = "Estado: ${address.state}")
        }
    }
}

@Composable
@Preview
fun HistoricComponentPreview() {
    AddressCard(
        AddressEntity(
            "00000-000",
            "Avenida Brasil",
            "Ao lado de cá",
            "Jardim Brasil",
            "São Paulo",
            "SP"
        ), {}
    )
}