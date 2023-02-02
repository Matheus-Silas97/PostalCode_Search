package com.matheussilas97.di.modules

import androidx.room.Room
import com.matheussilas97.data.Apifactory
import com.matheussilas97.search.data.repository.AddressRepositoryImpl
import com.matheussilas97.data_module.local.AppDatabase
import com.matheussilas97.historic.data.repository.AddressLocalRepositoryImpl
import com.matheussilas97.domain.repository.AddressLocalRepository
import com.matheussilas97.domain.repository.AddressRepository
import org.koin.dsl.module

val dataModule = module {

    factory { Room.databaseBuilder(get(), AppDatabase::class.java, "database").build() }

    single { Apifactory }

    single<AddressRepository> {
        com.matheussilas97.search.data.repository.AddressRepositoryImpl(
            addressService = get()
        )
    }

    single<AddressLocalRepository> {
        com.matheussilas97.historic.data.repository.AddressLocalRepositoryImpl(
            appDatabase = get()
        )
    }

}