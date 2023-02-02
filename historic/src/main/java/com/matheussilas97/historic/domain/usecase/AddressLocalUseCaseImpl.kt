package com.matheussilas97.historic.domain.usecase

import com.matheussilas97.common.entity.AddressEntity
import com.matheussilas97.historic.data.repository.AddressLocalRepository
import kotlinx.coroutines.flow.Flow

class AddressLocalUseCaseImpl(private val addressRepository: AddressLocalRepository) :
    AddressLocalUseCase {

    override suspend fun getAllAddress(): Flow<List<AddressEntity>> =
        addressRepository.getAllAddress()

    override suspend fun saveAddress(address: AddressEntity): Flow<Any?> =
        addressRepository.saveAddress(address)

    override suspend fun deleteAddress(address: AddressEntity): Flow<Any?> =
        addressRepository.deleteAddress(address)
}