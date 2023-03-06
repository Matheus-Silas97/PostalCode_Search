package com.matheussilas97.postalcodesearch.di

import com.matheussilas97.historic.presentation.HistoricViewModel
import com.matheussilas97.search.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel { HomeViewModel(addressUseCase = get(), addressLocalUseCase = get()) }

    viewModel { HistoricViewModel(historicUseCase = get()) }

}