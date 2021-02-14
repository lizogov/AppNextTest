package com.example.appnexttestapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class SectionsPagerAdapter(
    fm: FragmentManager, private val apps: List<AppModel>
) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount() = apps.size

    override fun getItem(position: Int): Fragment {
        return DetailsFragment.newInstance(apps[position])
    }
}