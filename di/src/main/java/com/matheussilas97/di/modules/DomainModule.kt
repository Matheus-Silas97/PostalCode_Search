package com.matheussilas97.di.modules

import com.matheussilas97.domain.usecase.AddressUseCase
import com.matheussilas97.domain.usecase.AddressUseCaseImpl
import org.koin.dsl.module

val domainModule = module {

    factory<AddressUseCase> { AddressUseCaseImpl(addressRepository = get()) }


}