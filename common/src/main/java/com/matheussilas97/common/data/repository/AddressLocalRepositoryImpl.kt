package com.matheussilas97.common.data.repository

import com.matheussilas97.common.domain.repository.AddressLocalRepository
import com.matheussilas97.common.entity.AddressEntity
import com.matheussilas97.common.local.AppDatabase
import com.matheussilas97.common.local.entity.Address
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class AddressLocalRepositoryImpl(private val appDatabase: AppDatabase) : AddressLocalRepository {

    override suspend fun saveAddress(address: AddressEntity): Any? = withContext(Dispatchers.IO) {
        return@withContext appDatabase.address().insert(
            Address(
                postalCode = address.postalCode ?: "",
                street = address.street ?: "",
                complement = address.complement ?: "",
                neighborhood = address.neighborhood ?: "",
                city = address.city ?: "",
                state = address.state ?: ""
            )
        )
    }

}