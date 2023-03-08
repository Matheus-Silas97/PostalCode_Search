package com.matheussilas97.historic.presentation

import com.matheussilas97.common.entity.AddressEntity

sealed class HistoricAddressInteraction {

    object LoadAllAddress : HistoricAddressInteraction()
    data class DeleteAddress(val address: AddressEntity) : HistoricAddressInteraction()
    data class ShowDeleteDialog(val address: AddressEntity): HistoricAddressInteraction()
    object CloseDeleteDialog: HistoricAddressInteraction()
    object CloseDialog: HistoricAddressInteraction()

}