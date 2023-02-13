package com.matheussilas97.search.domain.usecase

import com.matheussilas97.common.entity.AddressEntity
import kotlinx.coroutines.flow.Flow

interface AddressUseCase {

    suspend fun searchPostalCode(postalCode: String): Flow<AddressEntity?>

}