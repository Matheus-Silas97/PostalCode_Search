package com.matheussilas97.search.domain.repository

import com.matheussilas97.common.Resource
import com.matheussilas97.common.entity.AddressEntity
import kotlinx.coroutines.flow.Flow

interface AddressRepository {

    suspend fun searchCep(postalCode: String): Resource<AddressEntity?>

}