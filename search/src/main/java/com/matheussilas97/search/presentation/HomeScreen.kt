package com.matheussilas97.search.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.matheussilas97.common.utils.RouteNavigation
import com.matheussilas97.search.presentation.component.AddressCard
import com.matheussilas97.uikit.R
import com.matheussilas97.uikit.components.ActionButton
import org.koin.androidx.compose.getViewModel

@Composable
fun SearchAddressScreen(
    navController: NavController? = null,
    viewModel: HomeViewModel = getViewModel()
) {

    val state by viewModel.state.collectAsState()

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

                Image(
                    painter = painterResource(id = R.drawable.ic_location),
                    contentDescription = "location image",
                    modifier = Modifier.size(150.dp)
                )
                Spacer(modifier = Modifier.height(height = 8.dp))
                TextField(
                    value = "Digite um CEP",
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = {})
                Spacer(modifier = Modifier.height(height = 18.dp))
                ActionButton(
                    text = "Pesquisar CEP",
                    modifier = Modifier
                        .fillMaxWidth(),
                    click = {
                        viewModel.interact(interaction = SearchAddressInteraction.SearchAddress(postalCode = "08391607"))
                    })
                Spacer(modifier = Modifier.height(height = 18.dp))
                Text(text = "${state.addressEntity?.postalCode}")

                AddressCard(viewModel = viewModel)
            }
        })

}


@Composable
@Preview
fun ShowCard() {
    SearchAddressScreen()
}