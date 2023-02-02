package com.matheussilas97.historic.data.repository

import com.matheussilas97.common.entity.AddressEntity
import kotlinx.coroutines.flow.Flow

interface AddressLocalRepository {

    suspend fun getAllAddress(): Flow<List<AddressEntity>>

    suspend fun saveAddress(address: AddressEntity): Flow<Any?>

    suspend fun deleteAddress(address: AddressEntity): Flow<Any?>

}