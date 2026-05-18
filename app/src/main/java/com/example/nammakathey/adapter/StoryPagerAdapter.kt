package com.example.nammakathey.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.nammakathey.model.Hero
import com.example.nammakathey.ui.StoryFragment

class StoryPagerAdapter(
        activity: FragmentActivity,
        private val heroes: List<Hero>,
        private var isKannada: Boolean
) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = heroes.size

    override fun createFragment(position: Int): Fragment {
        return StoryFragment.newInstance(heroes[position], isKannada)
    }

    fun setLanguage(kannada: Boolean) {
        isKannada = kannada
        notifyDataSetChanged()
    }
}