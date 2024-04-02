package com.example.ecommerceconcept.detailsFragment

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.databinding.FragmentDetailsBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.math.abs

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding: FragmentDetailsBinding get() = requireNotNull(_binding)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
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
        fun newInstance() = DetailsFragment()
    }

    private fun init() {

        fillTestData()

        binding.cvBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun fillTestData() {
        val listPhoneImages = listOf(
            R.drawable.phone1,
            R.drawable.phone2,
            R.drawable.phone3,
            R.drawable.phone4,
            R.drawable.phone5,
        )

        val viewPager = binding.vpImage
        val adapterCarousel = CarouselAdapter(listPhoneImages)
        viewPager.adapter = adapterCarousel
        setUpTransformer(viewPager)

        val listFragment = listOf(
            ShopTabFragment.newInstance(),
            DetailsTabFragment.newInstance(),
            FeaturesTabFragment.newInstance(),
        )
        val listFragmentTitles = listOf(
            "Shop",
            "Details",
            "Features",
        )
        val vpAdapter = ViewPagerAdapter(requireActivity(), listFragment)
        binding.vpProductInfo.adapter = vpAdapter

        TabLayoutMediator(binding.tlTabs, binding.vpProductInfo) { tab, position ->
            tab.text = listFragmentTitles[position]
        }.attach()
    }

    private fun setUpTransformer(viewPager: ViewPager2) = with(viewPager) {
        clipChildren = false
        clipToPadding = false
        offscreenPageLimit = 3
        (getChildAt(0) as RecyclerView).overScrollMode =
            RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(
            MarginPageTransformer(
                (20 * Resources.getSystem().displayMetrics.density).toInt()
            )
        )
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = (0.80f + r * 0.20f)
        }
        setPageTransformer(compositePageTransformer)
    }
}