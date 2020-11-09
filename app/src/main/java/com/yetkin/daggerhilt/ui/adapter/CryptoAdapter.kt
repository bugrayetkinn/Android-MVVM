package com.yetkin.daggerhilt.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yetkin.daggerhilt.R
import com.yetkin.daggerhilt.data.model.CryptoModel
import com.yetkin.daggerhilt.databinding.ItemCryptoBinding


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
class CryptoAdapter : ListAdapter<CryptoModel, CryptoAdapter.CryptoViewHolder>(DiffCallBack) {

    class CryptoViewHolder(private val cryptoBinding: ItemCryptoBinding) :
        RecyclerView.ViewHolder(cryptoBinding.root) {

        fun bind(cryptoModel: CryptoModel) {
            cryptoBinding.cryptoModel = cryptoModel
        }
    }


    companion object {

        val DiffCallBack = object : DiffUtil.ItemCallback<CryptoModel>() {
            override fun areItemsTheSame(oldItem: CryptoModel, newItem: CryptoModel): Boolean =
                oldItem.currency == newItem.currency

            override fun areContentsTheSame(oldItem: CryptoModel, newItem: CryptoModel): Boolean =
                oldItem == newItem

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder =
        CryptoViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_crypto,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) =
        holder.bind(getItem(position))
}