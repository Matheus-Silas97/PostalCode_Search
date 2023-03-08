package com.matheussilas97.common.domain.usecase

import com.matheussilas97.common.entity.AddressEntity
import com.matheussilas97.common.domain.repository.AddressLocalRepository
import com.matheussilas97.common.domain.usecase.AddressLocalUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AddressLocalUseCaseImpl(private val addressRepository: AddressLocalRepository):
    AddressLocalUseCase {

    override suspend fun saveAddress(address: AddressEntity): Flow<Any?> =  flow { emit(addressRepository.saveAddress(address)) }

}