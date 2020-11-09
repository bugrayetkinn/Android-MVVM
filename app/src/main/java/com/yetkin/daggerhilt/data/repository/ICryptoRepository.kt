package com.yetkin.daggerhilt.data.repository

import com.yetkin.daggerhilt.data.model.CryptoModel
import com.yetkin.daggerhilt.util.Resource
import kotlinx.coroutines.flow.Flow


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
interface ICryptoRepository {

    fun fetchAllCryptoFromApi(): Flow<Resource<List<CryptoModel>>>
    fun fetchAllCryptoFromDb(): Flow<List<CryptoModel>>
    suspend fun deleteAllCryptoFromDb()
    suspend fun insertAll(cryptoList: List<CryptoModel>)
}