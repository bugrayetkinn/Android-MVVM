package com.yetkin.daggerhilt.di.module

import com.yetkin.daggerhilt.data.repository.CryptoRepository
import com.yetkin.daggerhilt.ui.viewmodel.CryptoViewModel
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
object CryptoViewModelModule {

    @Provides
    fun cryptoViewModel(cryptoRepository: CryptoRepository): CryptoViewModel =
        CryptoViewModel(cryptoRepository)

}