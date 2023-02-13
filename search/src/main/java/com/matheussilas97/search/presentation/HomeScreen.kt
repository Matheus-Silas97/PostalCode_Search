package com.matheussilas97.search.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.matheussilas97.common.utils.RouteNavigation
import com.matheussilas97.uikit.R
import com.matheussilas97.uikit.components.ActionButton
import com.matheussilas97.uikit.components.TextNormal
import com.matheussilas97.uikit.components.TopBar

@Composable
fun SearchAddressScreen(navController: NavController? = null) {
    Scaffold(modifier = Modifier.padding(all = 8.dp),
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController?.navigate(route = RouteNavigation.HISTORIC_SCREEN) },
                backgroundColor = Color.Blue,
                contentColor = Color.Black
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_history),
                    contentDescription = "icon historic"
                )
            }
        }, content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)
                    .padding(all = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = "Digite um CEP",
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = {})
                Spacer(modifier = Modifier.height(height = 18.dp))
                ActionButton(
                    text = "Pesquisar CEP",
                    modifier = Modifier
                        .fillMaxWidth(),
                    click = {})
            }
        })

}


@Composable
@Preview
fun ShowCard() {
    SearchAddressScreen()
}