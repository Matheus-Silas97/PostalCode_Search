package com.matheussilas97.historic.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheussilas97.common.entity.AddressEntity
import com.matheussilas97.historic.domain.usecase.HistoricAddressUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HistoricViewModel(private val historicUseCase: HistoricAddressUseCase) : ViewModel() {

    private val _state = MutableStateFlow(HistoricAddressState(isLoading = true))
    val state: StateFlow<HistoricAddressState> = _state

    fun interact(interaction: HistoricAddressInteraction) {
        when (interaction) {
            is HistoricAddressInteraction.LoadAllAddress -> getAllAddress()
            is HistoricAddressInteraction.SaveAddress -> saveAddress(address = interaction.address)
            is HistoricAddressInteraction.DeleteAddress -> saveAddress(address = interaction.address)
        }
    }

    init {
        interact(interaction = HistoricAddressInteraction.LoadAllAddress)
    }

    private fun getAllAddress() {
        viewModelScope.launch {
            historicUseCase.getAllAddress()
                .onStart {
                    _state.update { it.copy(isLoading = true, error = null) }
                }.catch { throwable ->
                    _state.update { it.copy(error =  throwable.message, isLoading = false, addressEntity = null, saveAddress = false, deleteAddress = false) }
                }.collect {addressList->
                    _state.update { it.copy(addressEntity = addressList, isLoading = false, error = null) }
                }
        }
    }

    private fun saveAddress(address: AddressEntity) {
        viewModelScope.launch {
            historicUseCase.saveAddress(address = address)
                .onStart {
                    _state.update { it.copy(isLoading = true, error = null) }
                }.catch { throwable ->
                    _state.update { it.copy(error =  throwable.message, isLoading = false, addressEntity = null, saveAddress = false, deleteAddress = false) }
                }.collect {
                    _state.update { it.copy(saveAddress = true, addressEntity = null, isLoading = false, error = null) }
                }
        }
    }

    private fun deleteAddress(address: AddressEntity) {
        viewModelScope.launch {
            historicUseCase.deleteAddress(address = address)
                .onStart {
                    _state.update { it.copy(isLoading = true, error = null) }
                }.catch { throwable ->
                    _state.update { it.copy(error =  throwable.message, isLoading = false, addressEntity = null, saveAddress = false, deleteAddress = false) }
                }.collect {
                    _state.update { it.copy(deleteAddress = true, addressEntity = null, isLoading = false, error = null) }
                }
        }
    }

}