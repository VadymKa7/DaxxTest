package com.vadym.daxxtest.ui.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.vadym.daxxtest.ui.child.ChildFragment

class NestedFragmentAdapter internal constructor(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int = 3

    override fun getItem(position: Int): Fragment {

        val args = Bundle().apply {
            putInt(ChildFragment.POSITION_KEY, position)
        }
        return ChildFragment.newInstance(args)
    }

    override fun getPageTitle(position: Int): CharSequence =
        when (position) {
            0 -> "One"
            1 -> "Two"
            2 -> "Three"
            else -> ""
        }

}