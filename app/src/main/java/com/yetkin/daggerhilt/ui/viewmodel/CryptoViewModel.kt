package com.yetkin.daggerhilt.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.yetkin.daggerhilt.data.model.CryptoModel
import com.yetkin.daggerhilt.data.repository.CryptoRepository
import com.yetkin.daggerhilt.util.Resource
import kotlinx.coroutines.launch


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */

class CryptoViewModel @ViewModelInject constructor(private val cryptoRepository: CryptoRepository) :
    ViewModel() {

    val allCryptoFromApi: LiveData<Resource<List<CryptoModel>>> = fetchAllCryptoFromApi()

    val allCryptoFromDb: LiveData<List<CryptoModel>> = fetchAllCryptoFromDb()

    init {
        fetchAllCryptoFromApi()
        fetchAllCryptoFromDb()
    }

    fun refreshData() {
        fetchAllCryptoFromApi()
    }

    private fun fetchAllCryptoFromDb(): LiveData<List<CryptoModel>> =
        cryptoRepository.fetchAllCryptoFromDb().asLiveData()

    private fun fetchAllCryptoFromApi(): LiveData<Resource<List<CryptoModel>>> =
        cryptoRepository.fetchAllCryptoFromApi().asLiveData(viewModelScope.coroutineContext)

    fun deleteAllCryptoFromDb() = viewModelScope.launch { cryptoRepository.deleteAllCryptoFromDb() }

    /*private fun fetchAllCryptoFromApi(): LiveData<Resource<List<CryptoModel>>> =
        cryptoRepository.fetchAllCryptoFromApi().asLiveData(viewModelScope.coroutineContext)*/


}