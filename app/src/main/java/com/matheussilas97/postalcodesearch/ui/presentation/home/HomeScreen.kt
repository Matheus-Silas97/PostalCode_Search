package com.matheussilas97.postalcodesearch.ui.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matheussilas97.postalcodesearch.ui.theme.Shapes


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
        shape = Shapes.medium,
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
@Preview
fun ShowCard() {
    CardAddress()
}