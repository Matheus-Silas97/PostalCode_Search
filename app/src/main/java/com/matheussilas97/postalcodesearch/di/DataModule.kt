package com.matheussilas97.postalcodesearch.di

import androidx.room.Room
import com.matheussilas97.common.client.Apifactory
import com.matheussilas97.common.client.ClientConfig
import com.matheussilas97.common.data.repository.AddressLocalRepositoryImpl
import com.matheussilas97.common.domain.repository.AddressLocalRepository
import com.matheussilas97.common.local.AppDatabase
import com.matheussilas97.historic.data.repository.HistoricAddressRepositoryImpl
import com.matheussilas97.historic.domain.repository.HistoricAddressRepository
import com.matheussilas97.search.data.repository.AddressRepositoryImpl
import com.matheussilas97.search.data.service.AddressService
import com.matheussilas97.search.data.service.AddressServiceImpl
import com.matheussilas97.search.domain.repository.AddressRepository
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val dataModule = module {

    factory { Room.databaseBuilder(get(), AppDatabase::class.java, "database").build() }

    single { ClientConfig.create() }

    single { Dispatchers.IO }
    single<AddressService> { AddressServiceImpl(get()) }

    factory<AddressRepository> {
        AddressRepositoryImpl(
            addressService = get(), defaultDispatcher = get()
        )
    }

    factory<HistoricAddressRepository> {
        HistoricAddressRepositoryImpl(
            appDatabase = get()
        )
    }

    factory<AddressLocalRepository> { AddressLocalRepositoryImpl(appDatabase = get()) }

}