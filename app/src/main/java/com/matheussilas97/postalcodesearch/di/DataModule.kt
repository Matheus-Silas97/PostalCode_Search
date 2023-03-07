package com.matheussilas97.postalcodesearch.di

import androidx.room.Room
import com.matheussilas97.common.client.Apifactory
import com.matheussilas97.common.data.repository.AddressLocalRepositoryImpl
import com.matheussilas97.common.domain.repository.AddressLocalRepository
import com.matheussilas97.common.local.AppDatabase
import com.matheussilas97.historic.data.repository.HistoricAddressRepository
import com.matheussilas97.historic.data.repository.HistoricAddressRepositoryImpl
import com.matheussilas97.search.domain.repository.AddressRepository
import com.matheussilas97.search.data.repository.AddressRepositoryImpl
import com.matheussilas97.search.data.service.AddressService
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val dataModule = module {

    factory { Room.databaseBuilder(get(), AppDatabase::class.java, "database").build() }

    single { Apifactory.create(serviceClass = AddressService::class.java) }

    single { Dispatchers.IO }

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