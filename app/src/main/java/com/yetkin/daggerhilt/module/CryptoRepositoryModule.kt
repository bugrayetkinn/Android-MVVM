package com.yetkin.daggerhilt.module

import com.yetkin.daggerhilt.data.network.CryptoApi
import com.yetkin.daggerhilt.repository.CryptoRepository
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
    fun cryptoRepository(cryptoApi: CryptoApi): CryptoRepository =
        CryptoRepository(cryptoApi)
}