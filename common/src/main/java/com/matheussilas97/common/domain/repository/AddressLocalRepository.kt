package com.matheussilas97.common.domain.repository

import com.matheussilas97.common.entity.AddressEntity
import kotlinx.coroutines.flow.Flow

interface AddressLocalRepository {

    suspend fun saveAddress(address: AddressEntity): Any?

}