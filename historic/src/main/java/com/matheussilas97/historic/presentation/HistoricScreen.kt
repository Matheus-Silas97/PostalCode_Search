package com.matheussilas97.historic.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.matheussilas97.historic.R
import com.matheussilas97.uikit.components.AddressCard
import com.matheussilas97.uikit.components.TopBar
import kotlinx.coroutines.coroutineScope
import org.koin.androidx.compose.getViewModel

@Composable
fun HistoricScreen(navController: NavHostController, viewModel: HistoricViewModel = getViewModel()) {

    val state by viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            TopBar(
                title = stringResource(R.string.historic),
                onBackPressed = { navController.popBackStack() })
        }, content = {
            val lazyState = rememberLazyListState()
            LazyColumn(state = lazyState) {
                items(items = state.addressEntity?: listOf()){ address->
                    AddressCard(address = address)
                }
            }
        })
}


