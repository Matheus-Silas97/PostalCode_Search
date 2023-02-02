package com.matheussilas97.search.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matheussilas97.postalcodesearch.components.ActionButton
import com.matheussilas97.postalcodesearch.components.TextNormal
import com.matheussilas97.uikit.theme.Shapes


@Composable
fun ListAddressScreen() {
    val lazyState = rememberLazyListState()
    LazyColumn(state = lazyState) {
        items(listOf("")) { address ->
            CardAddress()
        }
    }
}

@Composable
fun CardAddress() {
    Card(
        shape = com.matheussilas97.uikit.theme.Shapes.medium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 12.dp),
    ) {
        Column {
            Text(text = "", modifier = Modifier.fillMaxWidth())
            Text(text = "", modifier = Modifier.fillMaxWidth())
        }
    }
}

@Composable
fun SearchAddressScreen(navController: androidx.navigation.NavHostController) {
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


@Composable
@Preview
fun ShowCard() {
    CardAddress()
}