package com.matheussilas97.historic.data.repository

import com.matheussilas97.common.data.mapper.toAddressObject
import com.matheussilas97.common.domain.model.Address
import com.matheussilas97.common.local.AppDatabase
import com.matheussilas97.historic.data.mapper.toAddressList
import com.matheussilas97.historic.domain.repository.HistoricAddressRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HistoricAddressRepositoryImpl(private val appDatabase: AppDatabase) :
    HistoricAddressRepository {

    override suspend fun getAllAddress(): List<Address> = withContext(Dispatchers.IO) {
        return@withContext appDatabase.address().getAll().toAddressList()
    }

    override suspend fun deleteAddress(address: Address): Any = withContext(Dispatchers.IO) {
        return@withContext appDatabase.address().deleteTraining(
            address = address.toAddressObject()
        )
    }
}