package com.matheussilas97.domain.usecase

import com.matheussilas97.domain.entity.AddressEntity
import kotlinx.coroutines.flow.Flow

interface AddressUseCase {

    fun searchPostalCode(postalCode: String): Flow<AddressEntity?>

}