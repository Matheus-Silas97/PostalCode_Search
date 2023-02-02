package com.matheussilas97.historic.data.repository

import com.matheussilas97.common.entity.AddressEntity
import com.matheussilas97.common.local.AppDatabase
import com.matheussilas97.common.local.entity.Address
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AddressLocalRepositoryImpl(private val appDatabase: AppDatabase) : AddressLocalRepository {

    override suspend fun getAllAddress(): Flow<List<AddressEntity>> = flow {
        val response = appDatabase.address().getAll().map {
            AddressEntity(
                postalCode = it.postalCode,
                street = it.street,
                complement = it.complement,
                neighborhood = it.neighborhood,
                city = it.city,
                state = it.state
            )
        }
        emit(response)
    }

    override suspend fun saveAddress(address: AddressEntity): Flow<Any?> = flow {
        val response = appDatabase.address().insert(
            Address(
                postalCode = address.postalCode,
                street = address.street,
                complement = address.complement,
                neighborhood = address.neighborhood,
                city = address.city,
                state = address.state
            )
        )
        emit(response)
    }

    override suspend fun deleteAddress(address: AddressEntity): Flow<Any?> = flow {
        val response = appDatabase.address().deleteTraining(
            Address(
                postalCode = address.postalCode,
                street = address.street,
                complement = address.complement,
                neighborhood = address.neighborhood,
                city = address.city,
                state = address.state
            )
        )
        emit(response)
    }
}