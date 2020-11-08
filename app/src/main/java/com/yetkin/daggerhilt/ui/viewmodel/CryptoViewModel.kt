package com.yetkin.daggerhilt.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.yetkin.daggerhilt.data.model.CryptoModel
import com.yetkin.daggerhilt.repository.CryptoRepository
import com.yetkin.daggerhilt.util.Resource


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
// Viewmodelinject için     kapt 'androidx.hilt:hilt-compiler:1+' eklenecek

class CryptoViewModel @ViewModelInject constructor(private val cryptoRepository: CryptoRepository) :
    ViewModel() {

    val allCryptoFromApi: LiveData<Resource<List<CryptoModel>>> = fetchAllCryptoFromApi()

    init {
        fetchAllCryptoFromApi()
    }

    private fun fetchAllCryptoFromApi(): LiveData<Resource<List<CryptoModel>>> =
        cryptoRepository.fetchAllCryptoFromApi().asLiveData(viewModelScope.coroutineContext)

}