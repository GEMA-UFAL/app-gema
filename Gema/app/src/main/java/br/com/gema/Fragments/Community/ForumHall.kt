package br.com.gema.Fragments.Community


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import br.com.gema.Fragments.Community.Sections.DataStructuresSection
import br.com.gema.Fragments.Community.Sections.GeometrySection
import br.com.gema.Fragments.Community.Sections.GraphSection

import br.com.gema.R
import kotlinx.android.synthetic.main.fragment_forum_main.*


class ForumHall : androidx.fragment.app.Fragment() {


    companion object {
        @JvmStatic
        fun newInstance() = ForumHall()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_forum_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        materialViewPager.viewPager.adapter =
            ForumMainPagerAdapter(childFragmentManager)
        materialViewPager.viewPager.offscreenPageLimit = materialViewPager.viewPager.adapter!!.count
        materialViewPager.pagerTitleStrip.setViewPager(materialViewPager.viewPager)

    }


    class ForumMainPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

        var titles : ArrayList<String> = arrayListOf("GRAFOS", "ESTRUTURAS", "GEOMETRIA")

        override fun getPageTitle(position: Int): CharSequence? {
            return titles[position]
        }

        override fun getItem(position: Int): androidx.fragment.app.Fragment {
            return when (position) {
                0 -> GraphSection.newInstance()
                1 -> DataStructuresSection.newInstance()
                else -> GeometrySection.newInstance()
            }
        }

        override fun getCount(): Int {
            return titles.size
        }
    }


}
