package com.matheussilas97.historic.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.matheussilas97.common.domain.model.Address
import com.matheussilas97.common.R
import com.matheussilas97.historic.presentation.components.DeleteDialogComponent
import com.matheussilas97.uikit.components.AddressCard
import com.matheussilas97.uikit.components.ErrorDialog
import com.matheussilas97.uikit.components.TopBar
import org.koin.androidx.compose.getViewModel

@Composable
fun HistoricScreen(
    navController: NavHostController,
    viewModel: HistoricViewModel = getViewModel()
) {

    val state by viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            TopBar(
                title = stringResource(R.string.historic),
                onBackPressed = { navController.popBackStack() })
        }, content = {

            if (!state.error.isNullOrEmpty()) {
                ErrorDialog(throwable = Throwable(message = state.error)) {
                    viewModel.interact(interaction = HistoricAddressInteraction.CloseDialog)
                }
            }

            if (state.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(40.dp)
                        .scale(0.8f)
                )
            }

            if (state.showDeleteAddressDialog) {
                DeleteDialogComponent(
                    delete = {
                        viewModel.interact(
                            HistoricAddressInteraction.DeleteAddress(
                                state.addressForDelete ?: Address()
                            )
                        )
                    },
                    onCloseDialog = { viewModel.interact(HistoricAddressInteraction.CloseDeleteDialog) })
            }

            val lazyState = rememberLazyListState()
            LazyColumn(state = lazyState, modifier = Modifier.padding(all = 8.dp)) {
                items(items = state.addressEntity ?: listOf()) { address ->
                    AddressCard(
                        address = address,
                        deleteAddress = {
                            viewModel.interact(
                                interaction = HistoricAddressInteraction.ShowDeleteDialog(
                                    address = address
                                )
                            )
                        })
                }
            }
        })
}


