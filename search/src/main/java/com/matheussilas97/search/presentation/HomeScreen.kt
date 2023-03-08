package com.matheussilas97.search.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.matheussilas97.common.utils.RouteNavigation
import com.matheussilas97.search.presentation.component.AddressCard
import com.matheussilas97.uikit.R
import com.matheussilas97.uikit.components.ActionButton
import com.matheussilas97.uikit.components.ErrorDialog
import org.koin.androidx.compose.getViewModel

@Composable
fun SearchAddressScreen(
    navController: NavController? = null,
    viewModel: HomeViewModel = getViewModel()
) {

    val state by viewModel.state.collectAsState()
    var searchValueState by remember { mutableStateOf("") }

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

                Spacer(modifier = Modifier.height(height = 12.dp))

                OutlinedTextField(
                    value = searchValueState,
                    onValueChange = { searchValueState = it },
                    placeholder = { Text(text = "Digite um CEP") },
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                )

                Spacer(modifier = Modifier.height(height = 18.dp))

                ActionButton(
                    text = "Pesquisar CEP",
                    modifier = Modifier
                        .fillMaxWidth(),
                    click = {
                        if (searchValueState.length >= 8) {
                            viewModel.interact(
                                interaction = SearchAddressInteraction.SearchAddress(
                                    postalCode = searchValueState
                                )
                            )
                        }
                    })

                if (state.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(40.dp)
                            .scale(0.8f)
                    )
                }

                if (!state.error.isNullOrEmpty()) {
                    ErrorDialog(throwable = Throwable(message = state.error)) {
                        viewModel.interact(SearchAddressInteraction.CloseDialog)
                    }
                }

                Spacer(modifier = Modifier.height(height = 18.dp))

                AddressCard(viewModel = viewModel)
            }
        })
}


@Composable
@Preview
fun ShowCard() {
    SearchAddressScreen()
}