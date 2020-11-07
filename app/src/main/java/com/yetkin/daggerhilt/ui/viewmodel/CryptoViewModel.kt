package com.yetkin.daggerhilt.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.yetkin.daggerhilt.data.model.CryptoModel
import com.yetkin.daggerhilt.repository.CryptoRepository
import com.yetkin.daggerhilt.util.Resource
import kotlinx.coroutines.launch


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

    private fun fetchAllCryptoFromApi(): MutableLiveData<Resource<List<CryptoModel>>> {

        var _allCryptoFromApi = MutableLiveData<Resource<List<CryptoModel>>>()

        viewModelScope.launch {
            _allCryptoFromApi = cryptoRepository.fetchAllCryptoFromApi()
                .asLiveData() as MutableLiveData<Resource<List<CryptoModel>>>
        }
        return _allCryptoFromApi
    }

}