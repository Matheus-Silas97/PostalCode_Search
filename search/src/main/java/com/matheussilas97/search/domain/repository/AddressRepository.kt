package com.matheussilas97.search.domain.repository

import com.matheussilas97.common.domain.model.Address

interface AddressRepository {

    suspend fun searchCep(postalCode: String): Address?

}