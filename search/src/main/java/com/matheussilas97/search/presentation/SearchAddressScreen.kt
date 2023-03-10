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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.matheussilas97.common.R.string
import com.matheussilas97.common.domain.model.Address
import com.matheussilas97.common.utils.RouteNavigation
import com.matheussilas97.uikit.R
import com.matheussilas97.uikit.components.ActionButton
import com.matheussilas97.uikit.components.AddressCard
import com.matheussilas97.uikit.components.ErrorDialog
import org.koin.androidx.compose.getViewModel

@Composable
fun SearchAddressScreen(
    navController: NavController? = null,
    viewModel: SearchAddressViewModel = getViewModel()
) {

    val state by viewModel.state.collectAsState()
    var searchValueState by remember { mutableStateOf("") }

    Scaffold(backgroundColor = MaterialTheme.colors.background,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController?.navigate(route = RouteNavigation.HISTORIC_SCREEN) },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = MaterialTheme.colors.secondary,
                modifier = Modifier.padding(all = 8.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_history),
                    contentDescription = stringResource(string.icon_historic)
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
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = stringResource(string.location_image),
                    modifier = Modifier.size(250.dp)
                )

                OutlinedTextField(
                    value = searchValueState,
                    onValueChange = { searchValueState = it },
                    placeholder = { Text(text = stringResource(string.enter_a_zip_code)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = MaterialTheme.colors.background),
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                )

                Spacer(modifier = Modifier.height(height = 18.dp))

                ActionButton(
                    text = stringResource(string.search_for_zip_code),
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
                        viewModel.interact(interaction = SearchAddressInteraction.CloseDialog)
                    }
                }

                Spacer(modifier = Modifier.height(height = 18.dp))

                AddressCard(address = state.addressEntity ?: Address())
            }
        })
}


@Composable
@Preview
fun ShowCard() {
    SearchAddressScreen()
}