package com.matheussilas97.search.data.repository

import com.matheussilas97.common.entity.AddressEntity
import com.matheussilas97.search.data.service.AddressService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AddressRepositoryImpl(private val addressService: AddressService) : AddressRepository {

    override suspend fun searchCep(postalCode: String): Flow<AddressEntity?> = flow {
        val response = addressService.searchPostalCode(postalCode = postalCode)
        emit(
            AddressEntity(
                postalCode = response?.postalCode ?: "",
                street = response?.street ?: "",
                complement = response?.complement ?: "",
                neighborhood = response?.neighborhood ?: "",
                city = response?.city ?: "",
                state = response?.state ?: ""
            )
        )
    }

}