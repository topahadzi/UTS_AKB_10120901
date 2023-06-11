package com.example.uts_akb_10120901.ui.onboarding

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.uts_akb_10120901.ui.onboarding.OnBoardingThreeFragment
import com.example.uts_akb_10120901.ui.onboarding.OnBoardingTwoFragment

class OnBoardingPagerAdapter constructor(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    private val pages = listOf(
        OnBoardingOneFragment(),
        OnBoardingTwoFragment(),
        OnBoardingThreeFragment()
    )

    override fun getItemCount(): Int = pages.size

    override fun createFragment(position: Int): Fragment = pages[position]

    private val pagesHash = pages.map { it.hashCode().toLong() }

    override fun getItemId(position: Int): Long = pages[position].hashCode().toLong()

    override fun containsItem(itemId: Long) = pagesHash.contains(itemId)

}