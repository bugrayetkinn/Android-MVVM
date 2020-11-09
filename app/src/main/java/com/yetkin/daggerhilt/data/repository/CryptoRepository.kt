package com.yetkin.daggerhilt.data.repository

import com.yetkin.daggerhilt.data.local.CryptoDao
import com.yetkin.daggerhilt.data.model.CryptoModel
import com.yetkin.daggerhilt.data.network.CryptoApi
import com.yetkin.daggerhilt.util.AppInfo
import com.yetkin.daggerhilt.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */

/**
 * TODO room kısmından devam et
 */
class CryptoRepository @Inject constructor(
    private val db: CryptoDao,
    private val api: CryptoApi
) : ICryptoRepository {

    override suspend fun fetchAllCryptoFromApi(): Flow<Resource<List<CryptoModel>>> = flow {

        try {
            emit(Resource.Loading())

            val response = api.getAllCrypto(AppInfo.KEY)
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(Resource.Success(it))
                    insertAll(it)
                }
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage))
        }
    }

    override fun fetchAllCryptoFromDb(): Flow<List<CryptoModel>> = db.getAllCrypto()

    override suspend fun deleteAllCryptoFromDb() = db.deleteAllCrypto()

    override suspend fun insertAll(cryptoList: List<CryptoModel>) = db.insertAll(cryptoList)
}