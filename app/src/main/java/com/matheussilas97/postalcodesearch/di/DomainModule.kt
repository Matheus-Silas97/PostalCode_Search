package com.matheussilas97.di.modules

import com.matheussilas97.historic.domain.usecase.AddressLocalUseCase
import com.matheussilas97.historic.domain.usecase.AddressLocalUseCaseImpl
import com.matheussilas97.search.domain.usecase.AddressUseCase
import com.matheussilas97.search.domain.usecase.AddressUseCaseImpl
import org.koin.dsl.module

val domainModule = module {

    factory<AddressUseCase> {
        AddressUseCaseImpl(
            addressRepository = get()
        )
    }

    factory<AddressLocalUseCase> {
        AddressLocalUseCaseImpl(
            addressRepository = get()
        )
    }

}