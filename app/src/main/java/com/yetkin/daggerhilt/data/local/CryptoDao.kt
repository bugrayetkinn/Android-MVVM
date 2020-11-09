package com.yetkin.daggerhilt.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.yetkin.daggerhilt.data.model.CryptoModel
import kotlinx.coroutines.flow.Flow


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
@Dao
interface CryptoDao {

    @Query("SELECT*FROM crypto")
    fun getAllCrypto(): Flow<List<CryptoModel>>

    @Insert
    suspend fun insertAll(cryptoList: List<CryptoModel>)

    @Query("DELETE FROM crypto")
    suspend fun deleteAllCrypto()
}