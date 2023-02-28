package com.matheussilas97.search.domain.usecase

import com.matheussilas97.common.Resource
import com.matheussilas97.common.entity.AddressEntity
import com.matheussilas97.search.domain.repository.AddressRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AddressUseCaseImpl(private val addressRepository: AddressRepository) : AddressUseCase {

    override suspend fun searchPostalCode(postalCode: String): Flow<AddressEntity?> = flow {
        emit(addressRepository.searchCep(postalCode))
    }

}