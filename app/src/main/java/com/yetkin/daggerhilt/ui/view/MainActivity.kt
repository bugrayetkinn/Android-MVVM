package com.yetkin.daggerhilt.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yetkin.daggerhilt.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint // Inject islemlerini yapıyor
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}