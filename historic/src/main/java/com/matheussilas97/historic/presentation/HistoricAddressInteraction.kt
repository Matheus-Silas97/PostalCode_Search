package com.matheussilas97.historic.presentation

import com.matheussilas97.common.entity.AddressEntity

sealed class HistoricAddressInteraction {

    object LoadAllAddress : HistoricAddressInteraction()

    data class SaveAddress(val address: AddressEntity) : HistoricAddressInteraction()

    data class DeleteAddress(val address: AddressEntity) : HistoricAddressInteraction()

}