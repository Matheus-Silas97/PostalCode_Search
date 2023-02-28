package com.matheussilas97.historic.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.matheussilas97.historic.R
import com.matheussilas97.uikit.components.TopBar

@Composable
fun HistoricScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopBar(
                title = stringResource(R.string.historic),
                onBackPressed = { navController.popBackStack() })
        }, content = {
            val lazyState = rememberLazyListState()
            LazyColumn(state = lazyState) {
//                items(items = ){address->
//                    AddressCard(address = address)
//                }
            }
        })
}


