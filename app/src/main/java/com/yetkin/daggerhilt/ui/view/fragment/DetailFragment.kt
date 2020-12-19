package com.yetkin.daggerhilt.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yetkin.daggerhilt.R
import com.yetkin.daggerhilt.data.model.CryptoModel
import com.yetkin.daggerhilt.databinding.FragmentDetailBinding
import kotlinx.android.synthetic.main.activity_main.*

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private lateinit var detailBinding: FragmentDetailBinding
    private var cryptoModel: CryptoModel? = null


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        requireActivity().toolbar.visibility = View.VISIBLE

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        detailBinding = FragmentDetailBinding.inflate(inflater)

        return detailBinding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireActivity().toolbar.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_detailFragment_to_homeFragment)
            findNavController().popBackStack(R.id.detailFragment, true)
        }

        arguments?.let {
            cryptoModel = it.getSerializable("cryptoModel") as CryptoModel?
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailBinding.cryptoModel = cryptoModel

        cryptoModel?.let {
            //Toast.makeText(requireContext(), it.currency, Toast.LENGTH_LONG).show()
        }
    }
}