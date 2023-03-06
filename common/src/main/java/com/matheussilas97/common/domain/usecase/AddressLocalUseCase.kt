package com.matheussilas97.common.domain.usecase

import com.matheussilas97.common.entity.AddressEntity
import kotlinx.coroutines.flow.Flow

interface AddressLocalUseCase {

    suspend fun saveAddress(address: AddressEntity): Flow<Any?>

}