package com.yetkin.daggerhilt.repository

import com.yetkin.daggerhilt.data.network.CryptoApi
import com.yetkin.daggerhilt.util.AppInfo
import com.yetkin.daggerhilt.util.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
class CryptoRepository @Inject constructor(
    private val api: CryptoApi
) {

    fun fetchAllCryptoFromApi() = flow {

        try {
            emit(Resource.Loading())

            val response = api.getAllCrypto(AppInfo.KEY)
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(Resource.Success(it))
                }
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage))
        }
    }
}