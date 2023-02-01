package com.matheussilas97.domain.repository

import com.matheussilas97.domain.entity.AddressEntity
import kotlinx.coroutines.flow.Flow

interface AddressRepository {

    fun searchCep(postalCode: String): Flow<AddressEntity?>

}