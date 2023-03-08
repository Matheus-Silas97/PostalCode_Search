package com.matheussilas97.search.domain.usecase

import com.matheussilas97.common.domain.model.Address
import kotlinx.coroutines.flow.Flow

interface AddressUseCase {

    suspend fun searchPostalCode(postalCode: String): Flow<Address?>

}