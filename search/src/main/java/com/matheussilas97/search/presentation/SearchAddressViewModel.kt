package com.matheussilas97.search.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheussilas97.common.domain.model.Address
import com.matheussilas97.common.domain.usecase.AddressLocalUseCase
import com.matheussilas97.search.domain.usecase.AddressUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class SearchAddressViewModel(
    private val addressUseCase: AddressUseCase,
    private val addressLocalUseCase: AddressLocalUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(SearchAddressState(isLoading = false))
    val state: StateFlow<SearchAddressState> = _state

    fun interact(interaction: SearchAddressInteraction) {
        when (interaction) {
            is SearchAddressInteraction.SearchAddress -> searchAddress(interaction.postalCode)
            is SearchAddressInteraction.CloseDialog -> closeDialog()
        }
    }

    private fun searchAddress(postalCode: String) {
        viewModelScope.launch {
            addressUseCase.searchPostalCode(postalCode = postalCode)
                .onStart {
                    _state.update { it.copy(addressEntity = null, isLoading = true, error = null) }
                }.catch { throwable ->
                    _state.update {
                        it.copy(
                            addressEntity = null,
                            isLoading = false,
                            error = throwable.message
                        )
                    }
                }.collect { addressEntity ->
                    _state.update {
                        it.copy(
                            addressEntity = addressEntity,
                            isLoading = false,
                            error = null
                        )
                    }
                    saveAddressInDataBase(addressEntity)
                }
        }
    }

    private fun saveAddressInDataBase(address: Address?) {
        viewModelScope.launch {
            address?.let { addressEntity ->
                addressLocalUseCase.saveAddress(address = addressEntity).catch { throwable ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = throwable.message
                        )
                    }
                }.collect {}
            }
        }
    }

    private fun closeDialog() {
        _state.update { it.copy(error = null) }
    }

}