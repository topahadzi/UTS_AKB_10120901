package com.example.uts_akb_10120901.ui.onboarding

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.uts_akb_10120901.MainActivity
import com.example.uts_akb_10120901.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class OnBoardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        val vpOnBoarding = findViewById<ViewPager2>(R.id.vpOnBoarding)
        val tlOnBoarding = findViewById<TabLayout>(R.id.tlOnBoarding)

        vpOnBoarding.apply {
            adapter = OnBoardingPagerAdapter(this@OnBoardingActivity)
            TabLayoutMediator(
                tlOnBoarding,
                this
            ) { tab, position ->
            }.attach()
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)

                    initSetBtnNext()
//                    initSetBtnPrevious()
                }
            })
        }

        initSetBtnNext()
//        initSetBtnPrevious()
        initSetOnClick()

    }

    private fun initSetBtnNext() {
        val vpOnBoarding = findViewById<ViewPager2>(R.id.vpOnBoarding)
        val btnNext = findViewById<Button>(R.id.btnNext)
        btnNext.text =
            if (vpOnBoarding.currentItem == 2) resources.getString(R.string.start)
            else resources.getString(R.string.next)
    }

//    private fun initSetBtnPrevious() {
//        val vpOnBoarding = findViewById<ViewPager2>(R.id.vpOnBoarding)
//        val btnPrevious = findViewById<Button>(R.id.btnPrevious)
//        btnPrevious.text =
//            if (vpOnBoarding.currentItem != 0) resources.getString(R.string.previous)
//            else resources.getString(R.string.skip)
//    }

    private fun initSetOnClick() {
        val vpOnBoarding = findViewById<ViewPager2>(R.id.vpOnBoarding)
//        val btnPrevious = findViewById<Button>(R.id.btnPrevious)
        val btnNext = findViewById<Button>(R.id.btnNext)

//        btnPrevious.setOnClickListener {
//            if(btnPrevious.text == resources.getString(R.string.skip)) {
//                vpOnBoarding.setCurrentItem(
//                    vpOnBoarding.currentItem.plus(2),
//                    true
//                )
//            } else {
//                vpOnBoarding.setCurrentItem(
//                    vpOnBoarding.currentItem.minus(1),
//                    true
//                )
//            }
//            initSetBtnNext()
//            initSetBtnPrevious()
//        }

        btnNext.setOnClickListener {
            if (vpOnBoarding.currentItem == 2) {
                startActivity(Intent(this, MainActivity::class.java))
            } else vpOnBoarding.setCurrentItem(
                vpOnBoarding.currentItem.plus(1),
                true
            )
            initSetBtnNext()
//            initSetBtnPrevious()
        }
    }

}