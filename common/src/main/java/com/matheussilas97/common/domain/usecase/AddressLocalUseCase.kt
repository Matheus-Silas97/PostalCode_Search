package com.matheussilas97.common.domain.usecase

import com.matheussilas97.common.domain.model.Address
import kotlinx.coroutines.flow.Flow

interface AddressLocalUseCase {

    suspend fun saveAddress(address: Address): Flow<Any?>

}