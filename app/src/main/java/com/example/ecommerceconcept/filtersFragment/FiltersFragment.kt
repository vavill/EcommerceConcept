package com.example.ecommerceconcept.filtersFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.ecommerceconcept.databinding.FragmentFiltersBinding
import com.google.android.material.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FiltersFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentFiltersBinding? = null
    private val binding: FragmentFiltersBinding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFiltersBinding.inflate(inflater, container, false)
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
        fun newInstance() = FiltersFragment()
    }

    private fun init() {

        val listBrand = listOf("Apple", "Samsung", "Xiaomi")
        val listPrice = listOf("Below $300", "$301 - $500", "$501 - $1000", "$1001 - $1500")
        val listSize = listOf("4.5 to 5.5 inches", "5.6 to 6.5 inches", "6.6 to 7.5 inches")

        val adapterBrand = ArrayAdapter(
            requireActivity().applicationContext,
            R.layout.support_simple_spinner_dropdown_item,
            listBrand
        )
        val adapterPrice = ArrayAdapter(
            requireActivity().applicationContext,
            R.layout.support_simple_spinner_dropdown_item,
            listPrice
        )
        val adapterSize = ArrayAdapter(
            requireActivity().applicationContext,
            R.layout.support_simple_spinner_dropdown_item,
            listSize
        )

        adapterBrand.setDropDownViewResource(
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
        )
        adapterPrice.setDropDownViewResource(
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
        )
        adapterSize.setDropDownViewResource(
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
        )

        binding.spinnerBrand.adapter = adapterBrand
        binding.spinnerPrice.adapter = adapterPrice
        binding.spinnerSize.adapter = adapterSize

        binding.cvClose.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
        }
    }


}