package com.yetkin.daggerhilt.di.module

import android.content.Context
import androidx.room.Room
import com.yetkin.daggerhilt.data.local.CryptoDao
import com.yetkin.daggerhilt.data.local.CryptoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
@Module
@InstallIn(ApplicationComponent::class)
object CryptoDatabaseModule {

    @Provides
    @Singleton
    fun cryptoDatabase(@ApplicationContext context: Context): CryptoDatabase =
        Room.databaseBuilder(context, CryptoDatabase::class.java, "crypto.db").build()

    @Provides
    @Singleton
    fun cryptoDao(cryptoDatabase: CryptoDatabase): CryptoDao =
        cryptoDatabase.cryptoDao()
}