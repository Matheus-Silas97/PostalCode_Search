package com.matheussilas97.common.domain.repository

import com.matheussilas97.common.domain.model.Address

interface AddressLocalRepository {

    suspend fun saveAddress(address: Address): Any?

}