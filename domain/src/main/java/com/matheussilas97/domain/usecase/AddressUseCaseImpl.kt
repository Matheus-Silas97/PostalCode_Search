package com.matheussilas97.domain.usecase

import com.matheussilas97.domain.entity.AddressEntity
import com.matheussilas97.domain.repository.AddressRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AddressUseCaseImpl(private val addressRepository: AddressRepository) : AddressUseCase {

    override fun searchPostalCode(postalCode: String): Flow<AddressEntity?> = flow {
        addressRepository.searchCep(postalCode)
    }

}