package com.matheussilas97.historic.data.repository

import com.matheussilas97.common.entity.AddressEntity
import com.matheussilas97.common.local.AppDatabase
import com.matheussilas97.common.local.entity.Address
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class HistoricAddressRepositoryImpl(private val appDatabase: AppDatabase) :
    HistoricAddressRepository {

    override suspend fun getAllAddress(): List<AddressEntity> = withContext(Dispatchers.IO) {
        return@withContext appDatabase.address().getAll().map {
            AddressEntity(
                postalCode = it.postalCode,
                street = it.street,
                complement = it.complement,
                neighborhood = it.neighborhood,
                city = it.city,
                state = it.state
            )
        }
    }

    override fun deleteAddress(address: AddressEntity): Flow<Any?> = flow {
        val response = appDatabase.address().deleteTraining(
            Address(
                postalCode = address.postalCode ?: "",
                street = address.street ?: "",
                complement = address.complement ?: "",
                neighborhood = address.neighborhood ?: "",
                city = address.city ?: "",
                state = address.state ?: ""
            )
        )
        emit(response)
    }
}