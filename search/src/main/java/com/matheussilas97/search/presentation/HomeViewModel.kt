package com.matheussilas97.search.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.matheussilas97.common.Resource

import com.matheussilas97.common.entity.AddressEntity
import com.matheussilas97.search.domain.AddressState
import com.matheussilas97.search.domain.usecase.AddressUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HomeViewModel(private val addressUseCase: AddressUseCase) : ViewModel() {

    private var getAddressStateFlow by mutableStateOf(AddressState())
        private set

//    val _getAddressStateFlow: StateFlow<Resource<AddressEntity?>>
//        get() = getAddressStateFlow

    fun searchAddress(postalCode: String) {
        viewModelScope.launch {
            getAddressStateFlow = getAddressStateFlow.copy(
                isLoading = true,
                error = null
            )

//            when(val result = addressUseCase.searchPostalCode().)


//            addressUseCase.searchPostalCode(postalCode = postalCode)
//                .onStart {
//                    getAddressStateFlow.update { Loading() }
//                }.catch {
//                    getAddressStateFlow.update { Failure() }
//                }.collect {
//                    getAddressStateFlow.update { it }
//                }
        }
    }

}