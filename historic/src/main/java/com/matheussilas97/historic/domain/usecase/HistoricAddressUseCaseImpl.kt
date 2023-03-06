package com.matheussilas97.historic.domain.usecase

import com.matheussilas97.common.entity.AddressEntity
import com.matheussilas97.historic.data.repository.HistoricAddressRepository
import kotlinx.coroutines.flow.Flow

class HistoricAddressUseCaseImpl(private val addressRepository: HistoricAddressRepository) :
    HistoricAddressUseCase {

    override suspend fun getAllAddress(): Flow<List<AddressEntity>> =
        addressRepository.getAllAddress()

    override suspend fun deleteAddress(address: AddressEntity): Flow<Any?> =
        addressRepository.deleteAddress(address)
}