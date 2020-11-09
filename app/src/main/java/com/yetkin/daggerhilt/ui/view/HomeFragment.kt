package com.yetkin.daggerhilt.ui.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.yetkin.daggerhilt.R
import com.yetkin.daggerhilt.ui.adapter.CryptoAdapter
import com.yetkin.daggerhilt.ui.viewmodel.CryptoViewModel
import com.yetkin.daggerhilt.util.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.delay

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {


    private val cryptoViewModel: CryptoViewModel by viewModels()

    private lateinit var cryptoAdapter: CryptoAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        floatingActionButton.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_homeFragment_to_detailFragment)
        }
        initializeRecycler()

        /*cryptoViewModel.allCryptoFromDb.observe(this, {
        })*/

        cryptoViewModel.allCryptoFromApi.observe(viewLifecycleOwner, {

            when (it.status) {

                Status.LOADING -> {
                    Log.e("LOADING", "...")
                    progressbar.visibility = View.VISIBLE
                }
                Status.SUCCESS -> {
                    Log.e("SUCCESS", "...")
                    cryptoAdapter.submitList(it.data)
                    progressbar.visibility = View.INVISIBLE
                }
                Status.ERROR -> {
                    Log.e("ERROR", "${it.exception}")
                }
            }
        })

        //todo swipe refresh 5 dakika altında ise fake refresh değilse apiden çek
        swipe_refresh.setOnRefreshListener {

            recyclerView.visibility = View.GONE
            //eski time ile kullanıcının swipe yaptığı time'ı gönderip viewmodel'da işlem yapabiliriz
            cryptoViewModel.refreshData()
            lifecycleScope.launchWhenCreated {
                delay(2000)
                recyclerView.visibility = View.VISIBLE
                swipe_refresh.isRefreshing = false
            }
        }
    }

    private fun initializeRecycler() {
        cryptoAdapter = CryptoAdapter()
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = cryptoAdapter
    }
}