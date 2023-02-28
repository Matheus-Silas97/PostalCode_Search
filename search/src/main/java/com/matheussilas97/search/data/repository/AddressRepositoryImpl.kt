package com.matheussilas97.search.data.repository

import com.matheussilas97.common.Resource
import com.matheussilas97.common.Resource.Success
import com.matheussilas97.common.entity.AddressEntity
import com.matheussilas97.search.data.mapper.toAddressEntity
import com.matheussilas97.search.data.service.AddressService
import com.matheussilas97.search.domain.repository.AddressRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class AddressRepositoryImpl(
    private val addressService: AddressService,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) : AddressRepository {

    override suspend fun searchCep(postalCode: String): AddressEntity? =
        withContext(defaultDispatcher) {
            addressService.searchPostalCode(postalCode = postalCode).toAddressEntity()
        }

}