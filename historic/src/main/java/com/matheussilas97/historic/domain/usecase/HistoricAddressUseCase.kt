package com.matheussilas97.historic.domain.usecase

import com.matheussilas97.common.domain.model.Address
import kotlinx.coroutines.flow.Flow

interface HistoricAddressUseCase {

     fun getAllAddress(): Flow<List<Address>>

     fun deleteAddress(address: Address): Flow<Any?>

}