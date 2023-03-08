package com.matheussilas97.common.domain.usecase

import com.matheussilas97.common.domain.model.Address
import com.matheussilas97.common.domain.repository.AddressLocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AddressLocalUseCaseImpl(private val addressRepository: AddressLocalRepository) :
    AddressLocalUseCase {

    override suspend fun saveAddress(address: Address): Flow<Any?> =
        flow { emit(addressRepository.saveAddress(address = address)) }

}