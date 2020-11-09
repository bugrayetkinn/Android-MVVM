package com.yetkin.daggerhilt.di.module

import com.yetkin.daggerhilt.data.local.CryptoDao
import com.yetkin.daggerhilt.data.network.CryptoApi
import com.yetkin.daggerhilt.data.repository.CryptoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
@Module
@InstallIn(ApplicationComponent::class)
object CryptoRepositoryModule {

    @Provides
    fun cryptoRepository(cryptoDao: CryptoDao, cryptoApi: CryptoApi): CryptoRepository =
        CryptoRepository(cryptoDao, cryptoApi)
}