package com.matheussilas97.historic.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheussilas97.common.entity.AddressEntity
import com.matheussilas97.historic.domain.usecase.HistoricAddressUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HistoricViewModel(private val historicUseCase: HistoricAddressUseCase) : ViewModel() {

    private val _state = MutableStateFlow(HistoricAddressState(isLoading = false))
    val state: StateFlow<HistoricAddressState> = _state

    fun interact(interaction: HistoricAddressInteraction) {
        when (interaction) {
            is HistoricAddressInteraction.LoadAllAddress -> getAllAddress()
            is HistoricAddressInteraction.DeleteAddress -> deleteAddress(address = interaction.address)
            is HistoricAddressInteraction.ShowDeleteDialog -> showDeleteAddress(address = interaction.address)
            is HistoricAddressInteraction.CloseDeleteDialog -> closeDeleteDialog()
            is HistoricAddressInteraction.CloseDialog -> closeDialog()
        }
    }

    init {
        interact(interaction = HistoricAddressInteraction.LoadAllAddress)
    }

    private fun getAllAddress() {
        viewModelScope.launch {
            historicUseCase.getAllAddress()
                .onStart {
                    _state.update {
                        it.copy(
                            isLoading = true, error = null,
                            addressForDelete = null
                        )
                    }
                }.catch { throwable ->
                    _state.update {
                        it.copy(
                            error = throwable.message,
                            isLoading = false,
                            addressEntity = null,
                            deleteAddress = false,
                            addressForDelete = null
                        )
                    }
                }.collect { addressList ->
                    _state.update {
                        it.copy(
                            addressEntity = addressList,
                            isLoading = false,
                            error = null,
                            addressForDelete = null
                        )
                    }
                }
        }
    }

    private fun deleteAddress(address: AddressEntity) {
        viewModelScope.launch {
            closeDeleteDialog()
            historicUseCase.deleteAddress(address = address)
                .onStart {
                    _state.update { it.copy(isLoading = true, error = null,
                        showAddressDialog = false) }
                }.catch { throwable ->
                    _state.update {
                        it.copy(
                            error = throwable.message,
                            isLoading = false,
                            addressEntity = null,
                            deleteAddress = false,
                            addressForDelete = null
                        )
                    }
                }.collect {
                    _state.update {
                        it.copy(
                            deleteAddress = true,
                            addressEntity = null,
                            isLoading = false,
                            error = null,
                            addressForDelete = null
                        )
                    }
                    getAllAddress()
                }
        }
    }

    private fun showDeleteAddress(address: AddressEntity) {
        _state.update { it.copy(addressForDelete = address, showAddressDialog = true) }
    }

    private fun closeDeleteDialog() {
        _state.update { it.copy(addressForDelete = null, showAddressDialog = false) }
    }

    private fun closeDialog() {
        _state.update { it.copy(error = null) }
    }
}