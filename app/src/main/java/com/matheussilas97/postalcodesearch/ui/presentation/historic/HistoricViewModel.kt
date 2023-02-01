package com.matheussilas97.postalcodesearch.ui.presentation.historic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheussilas97.domain.Failure
import com.matheussilas97.domain.Loading
import com.matheussilas97.domain.Resource
import com.matheussilas97.domain.Success
import com.matheussilas97.domain.entity.AddressEntity
import com.matheussilas97.domain.usecase.AddressLocalUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class HistoricViewModel(private val historicUseCase: AddressLocalUseCase) : ViewModel() {

    private val historicLiveData = MutableStateFlow<Resource<List<AddressEntity>>>(Loading())
    val _historicLiveData: StateFlow<Resource<List<AddressEntity>>>
        get() = historicLiveData

    private val saveAddressLiveData = MutableStateFlow<Resource<Any?>>(Loading())
    val _saveAddressLiveData: StateFlow<Resource<Any?>>
        get() = saveAddressLiveData

    private val deleteAddressLiveData = MutableStateFlow<Resource<Any?>>(Loading())
    val _deleteAddressLiveData: StateFlow<Resource<Any?>>
        get() = deleteAddressLiveData

    fun getAllAddress() {
        viewModelScope.launch {
            historicLiveData.value = Loading()
            historicUseCase.getAllAddress()
                .onStart {
                    historicLiveData.value = Loading()
                }.catch {
                    historicLiveData.value = Failure()
                }.collect {
                    historicLiveData.value = Success(data = it)
                }
        }
    }

    fun saveAddress(address: AddressEntity) {
        viewModelScope.launch {
            saveAddressLiveData.value = Loading()
            historicUseCase.saveAddress(address = address)
                .onStart {
                    saveAddressLiveData.value = Loading()
                }.catch {
                    saveAddressLiveData.value = Failure()
                }.collect {
                    saveAddressLiveData.value = Success(data = it)
                }
        }
    }

    fun deleteAddress(address: AddressEntity) {
        viewModelScope.launch {
            deleteAddressLiveData.value = Loading()
            historicUseCase.deleteAddress(address = address)
                .onStart {
                    deleteAddressLiveData.value = Loading()
                }.catch {
                    deleteAddressLiveData.value = Failure()
                }.collect {
                    deleteAddressLiveData.value = Success(data = it)
                }
        }
    }

}