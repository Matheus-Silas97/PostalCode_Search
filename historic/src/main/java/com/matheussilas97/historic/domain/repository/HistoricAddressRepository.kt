package com.matheussilas97.historic.domain.repository

import com.matheussilas97.common.domain.model.Address

interface HistoricAddressRepository {

    suspend fun getAllAddress(): List<Address>

    suspend fun deleteAddress(address: Address): Any?

}