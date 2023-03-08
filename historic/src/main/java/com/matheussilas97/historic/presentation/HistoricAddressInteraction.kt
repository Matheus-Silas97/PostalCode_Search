package com.matheussilas97.historic.presentation

import com.matheussilas97.common.domain.model.Address

sealed class HistoricAddressInteraction {

    object LoadAllAddress : HistoricAddressInteraction()

    data class DeleteAddress(val address: Address) : HistoricAddressInteraction()

    data class ShowDeleteDialog(val address: Address): HistoricAddressInteraction()

    object CloseDeleteDialog: HistoricAddressInteraction()

    object CloseDialog: HistoricAddressInteraction()

}