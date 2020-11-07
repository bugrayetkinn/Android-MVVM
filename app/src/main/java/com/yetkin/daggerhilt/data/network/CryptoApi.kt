package com.yetkin.daggerhilt.data.network

import com.yetkin.daggerhilt.data.model.CryptoModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
interface CryptoApi {
    @GET("prices")
    suspend fun getAllCrypto(@Query("key") key: String): Response<List<CryptoModel>>
}