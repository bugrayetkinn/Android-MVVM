package com.yetkin.daggerhilt.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
@Entity(tableName = "crypto")
data class CryptoModel(
    @PrimaryKey(autoGenerate = true) val _cryptoId: Long = 0,
    val currency: String,
    val price: String
)