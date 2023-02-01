package com.matheussilas97.domain.usecase

import com.matheussilas97.domain.entity.AddressEntity
import kotlinx.coroutines.flow.Flow

interface AddressLocalUseCase {

    suspend fun getAllAddress(): Flow<List<AddressEntity>>

    suspend fun saveAddress(address: AddressEntity): Flow<Any?>

    suspend fun deleteAddress(address: AddressEntity): Flow<Any?>

}