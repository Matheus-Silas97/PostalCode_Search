package com.matheussilas97.historic.domain.usecase

import com.matheussilas97.common.entity.AddressEntity
import kotlinx.coroutines.flow.Flow

interface HistoricAddressUseCase {

     fun getAllAddress(): Flow<List<AddressEntity>>

     fun deleteAddress(address: AddressEntity): Flow<Any?>

}