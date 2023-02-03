package com.matheussilas97.uikit.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matheussilas97.common.entity.AddressEntity
import com.matheussilas97.uikit.R

@Composable
fun AddressCard(address: AddressEntity) {
    val textAddressNeighborhood =
        "${address.street}, ${address.neighborhood}"
    val textCityState = " ${address.city} - ${address.state}"

    Card(
        border = BorderStroke(1.dp, Color.Gray),
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 2.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .padding(all = 8.dp)
            ) {
                TextNormal(text = textAddressNeighborhood, color = Color.Black)
                TextNormal(text = textCityState, color = Color.Black)
                TextNormal(text = address.postalCode, color = Color.Black)
            }
            Box(

            ) {
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .size(size = 30.dp)
                        .align(Alignment.CenterEnd)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_delete),
                        contentDescription = "icon delete"
                    )
                }
            }

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
        )
    )
}