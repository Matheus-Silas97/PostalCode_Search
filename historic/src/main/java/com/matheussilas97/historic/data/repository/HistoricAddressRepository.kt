package com.matheussilas97.historic.data.repository

import com.matheussilas97.common.entity.AddressEntity
import kotlinx.coroutines.flow.Flow

interface HistoricAddressRepository {

    suspend fun getAllAddress(): Flow<List<AddressEntity>>

    suspend fun deleteAddress(address: AddressEntity): Flow<Any?>

}