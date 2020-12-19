package com.yetkin.daggerhilt.ui.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.yetkin.daggerhilt.R
import com.yetkin.daggerhilt.ui.adapter.CryptoAdapter
import com.yetkin.daggerhilt.ui.viewmodel.CryptoViewModel
import com.yetkin.daggerhilt.util.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val cryptoViewModel: CryptoViewModel by viewModels()

    private lateinit var cryptoAdapter: CryptoAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        requireActivity().toolbar.visibility = View.GONE
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeRecycler()

        cryptoViewModel.allCryptoFromApi.observe(viewLifecycleOwner, {

            when (it.status) {

                Status.LOADING -> {
                    progressbar.visibility = View.VISIBLE
                }
                Status.SUCCESS -> {
                    cryptoAdapter.submitList(it.data)
                    progressbar.visibility = View.INVISIBLE
                }
                Status.ERROR -> {
                    Log.e("ERROR", "${it.exception}")
                }
            }
        })
    }

    private fun initializeRecycler() {
        cryptoAdapter = CryptoAdapter()
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = cryptoAdapter

        cryptoAdapter.setOnItemClickListener {
            val bundle = Bundle()
            bundle.putSerializable("cryptoModel", it)
            findNavController().navigate(R.id.action_homeFragment_to_detailFragment, bundle)
        }

    }
}