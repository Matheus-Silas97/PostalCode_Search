package com.matheussilas97.search.data.repository

import com.matheussilas97.common.entity.AddressEntity
import kotlinx.coroutines.flow.Flow

interface AddressRepository {

    fun searchCep(postalCode: String): Flow<AddressEntity?>

}