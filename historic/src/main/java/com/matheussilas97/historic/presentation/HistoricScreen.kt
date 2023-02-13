package com.matheussilas97.historic.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.matheussilas97.historic.R
import com.matheussilas97.uikit.components.AddressCard
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


