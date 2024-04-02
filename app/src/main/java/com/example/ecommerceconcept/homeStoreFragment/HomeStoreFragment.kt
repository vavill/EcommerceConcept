package com.example.ecommerceconcept.homeStoreFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.cartFragment.CartFragment
import com.example.ecommerceconcept.databinding.FragmentHomeStoreBinding
import com.example.ecommerceconcept.detailsFragment.DetailsFragment
import com.example.ecommerceconcept.filtersFragment.FiltersFragment

class HomeStoreFragment : Fragment() {

    private var _binding: FragmentHomeStoreBinding? = null
    private val binding: FragmentHomeStoreBinding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeStoreBinding.inflate(inflater, container, false)
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
        fun newInstance() = HomeStoreFragment()
    }

    private fun init() {

        fillTestData()

        binding.ivFilter.setOnClickListener {
            FiltersFragment.newInstance().show(
                requireActivity().supportFragmentManager,
                "filters"
            )
        }

        binding.bnvNavigation.itemActiveIndicatorColor =
            requireContext().getColorStateList(R.color.nav_menu_color)

        binding.bnvNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.cartItem -> {
                    addFragment(CartFragment.newInstance())
                    true
                }

                else -> {
                    true
                }
            }
        }
    }

    private fun fillTestData() {
        val listCategory = mutableListOf<Category>()
        repeat(2) {
            listCategory.add(Category("Phones", R.drawable.ic_phone))
            listCategory.add(Category("Computer", R.drawable.ic_computer))
            listCategory.add(Category("Health", R.drawable.ic_health))
            listCategory.add(Category("Books", R.drawable.ic_book))
        }

        val adapter = CategoryAdapter()
        adapter.setData(listCategory)
        binding.rvCategories.adapter = adapter

        val listBanner = listOf(
            R.drawable.banner1,
            R.drawable.banner2,
            R.drawable.banner3,
        )

        val adapterBanner = BannerAdapter()
        adapterBanner.setData(listBanner)
        binding.rvBanners.adapter = adapterBanner
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.rvBanners)


        val listProduct = mutableListOf<Product>()
        repeat(10) {
            listProduct.add(
                Product(
                    "Title$it",
                    1000,
                    1500,
                    R.drawable.xiaomi_14_ultra,
                    false
                )
            )
        }

        val adapterProduct = ProductAdapter {
            requireActivity().supportFragmentManager.commit {
                replace<DetailsFragment>(R.id.fragment_container)
                setReorderingAllowed(true)
                addToBackStack(null)
            }
        }

        adapterProduct.setData(listProduct.toList())
        binding.rvProducts.adapter = adapterProduct
    }

    private fun addFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.commit {
            replace(R.id.fragment_container, fragment)
            setReorderingAllowed(true)
            addToBackStack(null)
        }
    }
}