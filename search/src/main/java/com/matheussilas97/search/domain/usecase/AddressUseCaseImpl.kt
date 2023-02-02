package com.matheussilas97.search.domain.usecase

import com.matheussilas97.common.entity.AddressEntity
import com.matheussilas97.search.data.repository.AddressRepository
import kotlinx.coroutines.flow.Flow

class AddressUseCaseImpl(private val addressRepository: AddressRepository) : AddressUseCase {

    override fun searchPostalCode(postalCode: String): Flow<AddressEntity?> =
        addressRepository.searchCep(postalCode)

}