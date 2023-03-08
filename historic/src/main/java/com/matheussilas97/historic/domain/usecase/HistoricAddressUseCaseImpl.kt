package com.matheussilas97.historic.domain.usecase

import com.matheussilas97.common.domain.model.Address
import com.matheussilas97.historic.domain.repository.HistoricAddressRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HistoricAddressUseCaseImpl(private val addressRepository: HistoricAddressRepository) :
    HistoricAddressUseCase {

    override fun getAllAddress(): Flow<List<Address>> = flow {
        emit(addressRepository.getAllAddress())
    }

    override fun deleteAddress(address: Address): Flow<Any?> = flow {
        emit(addressRepository.deleteAddress(address))
    }
}