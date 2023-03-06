package com.matheussilas97.postalcodesearch.di

import com.matheussilas97.common.domain.usecase.AddressLocalUseCase
import com.matheussilas97.common.domain.usecase.AddressLocalUseCaseImpl
import com.matheussilas97.historic.domain.usecase.HistoricAddressUseCase
import com.matheussilas97.historic.domain.usecase.HistoricAddressUseCaseImpl
import com.matheussilas97.search.domain.usecase.AddressUseCase
import com.matheussilas97.search.domain.usecase.AddressUseCaseImpl
import org.koin.dsl.module

val domainModule = module {

    factory<AddressUseCase> {
        AddressUseCaseImpl(
            addressRepository = get()
        )
    }

    factory<HistoricAddressUseCase> {
        HistoricAddressUseCaseImpl(
            addressRepository = get()
        )
    }

    factory<AddressLocalUseCase> { AddressLocalUseCaseImpl(addressRepository = get()) }

}