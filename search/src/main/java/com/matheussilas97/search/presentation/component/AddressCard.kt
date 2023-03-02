package com.matheussilas97.search.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.matheussilas97.search.presentation.HomeViewModel
import com.matheussilas97.uikit.components.TextNormal

@Composable
fun AddressCard(viewModel: HomeViewModel) {

    val state by viewModel.state.collectAsState()

    Card(
        border = BorderStroke(1.dp, Color.Gray),
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp)
        ) {

            Text(text = "${state.addressEntity?.postalCode}")
            TextNormal(text = "CEP: ${state.addressEntity?.postalCode}")
            TextNormal(text = "Logradouro: ${state.addressEntity?.street}")
            TextNormal(text = "Complemento: ${state.addressEntity?.complement}")
            TextNormal(text = "Bairro: ${state.addressEntity?.neighborhood}")
            TextNormal(text = "Cidade: ${state.addressEntity?.city}")
            TextNormal(text = "Estado: ${state.addressEntity?.state}")
        }
    }
}

