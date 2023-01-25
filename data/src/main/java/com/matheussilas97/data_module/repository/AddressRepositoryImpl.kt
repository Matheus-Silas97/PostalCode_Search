package com.matheussilas97.data.repository

import com.matheussilas97.data.service.AddressService
import com.matheussilas97.domain.entity.AddressEntity
import com.matheussilas97.domain.repository.AddressRepository

class AddressRepositoryImpl(private val addressService: AddressService): AddressRepository {
    override fun searchCep(cep: String): AddressEntity {
        TODO("Not yet implemented")
    }
}