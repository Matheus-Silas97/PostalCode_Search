package com.matheussilas97.historic.domain.usecase

import com.matheussilas97.common.entity.AddressEntity
import com.matheussilas97.historic.data.repository.HistoricAddressRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HistoricAddressUseCaseImpl(private val addressRepository: HistoricAddressRepository) :
    HistoricAddressUseCase {

    override fun getAllAddress(): Flow<List<AddressEntity>> = flow {
        emit(addressRepository.getAllAddress())
    }

    override fun deleteAddress(address: AddressEntity): Flow<Any?> = flow {
        emit(addressRepository.deleteAddress(address))
    }
}