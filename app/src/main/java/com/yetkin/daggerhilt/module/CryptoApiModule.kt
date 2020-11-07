package com.yetkin.daggerhilt.module

import com.yetkin.daggerhilt.data.network.CryptoApi
import com.yetkin.daggerhilt.util.AppInfo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */

@Module
//Installin zorunlu scope'u belirtmek için
@InstallIn(ApplicationComponent::class)
object CryptoApiModule {

    @Provides
    @Singleton
    fun retrofitClient(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(AppInfo.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun createApi(retrofit: Retrofit): CryptoApi =
        retrofit.create(CryptoApi::class.java)

}