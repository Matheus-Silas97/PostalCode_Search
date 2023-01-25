package com.matheussilas97.domain.repository

import com.matheussilas97.domain.entity.AddressEntity

interface AddressRepository {

    fun searchCep(cep: String): AddressEntity

}