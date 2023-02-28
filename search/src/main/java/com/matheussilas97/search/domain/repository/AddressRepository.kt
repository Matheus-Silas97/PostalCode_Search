package com.matheussilas97.search.domain.repository

import com.matheussilas97.common.entity.AddressEntity

interface AddressRepository {

    suspend fun searchCep(postalCode: String): AddressEntity?

}