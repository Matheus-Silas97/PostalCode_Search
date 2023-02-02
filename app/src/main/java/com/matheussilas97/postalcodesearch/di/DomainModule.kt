package com.matheussilas97.di.modules

import com.matheussilas97.historic.domain.usecase.AddressLocalUseCase
import com.matheussilas97.historic.domain.usecase.AddressLocalUseCaseImpl
import com.matheussilas97.search.domain.usecase.AddressUseCase
import com.matheussilas97.search.domain.usecase.AddressUseCaseImpl
import org.koin.dsl.module

val domainModule = module {

    factory<com.matheussilas97.search.domain.usecase.AddressUseCase> {
        com.matheussilas97.search.domain.usecase.AddressUseCaseImpl(
            addressRepository = get()
        )
    }

    factory<com.matheussilas97.historic.domain.usecase.AddressLocalUseCase> {
        com.matheussilas97.historic.domain.usecase.AddressLocalUseCaseImpl(
            addressRepository = get()
        )
    }

}