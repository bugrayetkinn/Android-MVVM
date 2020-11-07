package com.yetkin.daggerhilt.ui.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.yetkin.daggerhilt.R
import com.yetkin.daggerhilt.ui.viewmodel.CryptoViewModel
import com.yetkin.daggerhilt.util.Status
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint // Inject islemlerini yapıyor
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var cryptoViewModel: CryptoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cryptoViewModel.allCryptoFromApi.observe(this, {

            when (it.status) {

                Status.LOADING -> {
                    Log.e("Loading", "...")
                }
                Status.SUCCESS -> {
                    Log.e("Success", "${it.data}")
                }
                Status.ERROR -> {
                    Log.e("Error", "${it.exception}")
                }
            }
        })
    }
}