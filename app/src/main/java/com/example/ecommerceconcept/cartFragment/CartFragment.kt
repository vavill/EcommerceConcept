package com.example.ecommerceconcept.cartFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.databinding.FragmentCartBinding

class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null
    private val binding: FragmentCartBinding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        fun newInstance() = CartFragment()
    }

    private fun init() {
        val listCart = mutableListOf<ProductCart>()
        repeat(5) {
            listCart.add(
                ProductCart(
                    "Iphone 15 Pro",
                    "$3000.00",
                    R.drawable.phone1
                )
            )
        }

        val adapterCart = RvCartAdapter()
        adapterCart.setData(listCart)
        binding.rvCart.adapter = adapterCart

        binding.cvBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }
}