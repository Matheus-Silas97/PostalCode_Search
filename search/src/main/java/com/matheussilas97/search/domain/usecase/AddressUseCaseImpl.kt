package com.matheussilas97.search.domain.usecase

import com.matheussilas97.common.domain.model.Address
import com.matheussilas97.search.domain.repository.AddressRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AddressUseCaseImpl(private val addressRepository: AddressRepository) : AddressUseCase {

    override suspend fun searchPostalCode(postalCode: String): Flow<Address?> = flow {
        emit(addressRepository.searchCep(postalCode = postalCode))
    }

}