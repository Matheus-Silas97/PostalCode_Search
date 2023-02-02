package com.matheussilas97.postalcodesearch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.matheussilas97.historic.presentation.HomeScreen
import com.matheussilas97.search.presentation.HomeViewModel
import com.matheussilas97.search.presentation.SearchAddressScreen
import com.matheussilas97.uikit.theme.PostalCodeSearchTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PostalCodeSearchTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavigationComponent()
                }
            }
        }
    }


    @Composable
    private fun NavigationComponent() {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "homeScreen") {
            composable(route = "homeScreen") {
                HomeScreen(navController)
            }
            composable(route = "searchAddress") {
                SearchAddressScreen(navController)
            }
        }
    }
}