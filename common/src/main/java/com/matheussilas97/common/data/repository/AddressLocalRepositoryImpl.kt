package com.matheussilas97.common.data.repository

import com.matheussilas97.common.data.mapper.toAddressObject
import com.matheussilas97.common.domain.repository.AddressLocalRepository
import com.matheussilas97.common.domain.model.Address
import com.matheussilas97.common.local.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AddressLocalRepositoryImpl(private val appDatabase: AppDatabase) : AddressLocalRepository {

    override suspend fun saveAddress(address: Address): Any = withContext(Dispatchers.IO) {
        return@withContext appDatabase.address().insert(
           address = address.toAddressObject()
        )
    }

}