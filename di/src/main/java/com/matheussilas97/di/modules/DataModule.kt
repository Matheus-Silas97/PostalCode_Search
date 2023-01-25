package com.matheussilas97.di.modules

import androidx.room.Room
import com.matheussilas97.data.Apifactory
import com.matheussilas97.data.repository.AddressRepositoryImpl
import com.matheussilas97.data_module.local.AppDatabase
import com.matheussilas97.domain.repository.AddressRepository
import org.koin.dsl.module

val dataModule = module {

    factory { Room.databaseBuilder(get(), AppDatabase::class.java, "database").build() }

    single { Apifactory }

    single<AddressRepository> { AddressRepositoryImpl(addressService = get()) }

}