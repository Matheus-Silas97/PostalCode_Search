package com.matheussilas97.di.modules

import androidx.room.Room
import com.matheussilas97.common.Apifactory
import com.matheussilas97.common.local.AppDatabase
import com.matheussilas97.historic.data.repository.AddressLocalRepository
import com.matheussilas97.historic.data.repository.AddressLocalRepositoryImpl
import com.matheussilas97.search.data.repository.AddressRepository
import com.matheussilas97.search.data.repository.AddressRepositoryImpl
import com.matheussilas97.search.data.service.AddressService
import org.koin.dsl.module

val dataModule = module {

    factory { Room.databaseBuilder(get(), AppDatabase::class.java, "database").build() }

    single { Apifactory.create(serviceClass = AddressService::class.java) }

    single<AddressRepository> {
        AddressRepositoryImpl(
            addressService = get()
        )
    }

    single<AddressLocalRepository> {
        AddressLocalRepositoryImpl(
            appDatabase = get()
        )
    }

}