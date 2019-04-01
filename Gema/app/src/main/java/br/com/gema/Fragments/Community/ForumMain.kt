package br.com.gema.Fragments.Community


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import br.com.gema.Fragments.Community.Forum.Sections.DataStructuresSection
import br.com.gema.Fragments.Community.Forum.Sections.GraphSection

import br.com.gema.R
import com.github.florent37.materialviewpager.MaterialViewPager
import com.github.florent37.materialviewpager.header.HeaderDesign
import kotlinx.android.synthetic.main.fragment_forum_main.*


class ForumMain : androidx.fragment.app.Fragment() {


    companion object {
        @JvmStatic
        fun newInstance() = ForumMain()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_forum_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        materialViewPager.viewPager.adapter = ForumMainPagerAdapter(childFragmentManager)
        materialViewPager.viewPager.offscreenPageLimit = materialViewPager.viewPager.adapter!!.count
        materialViewPager.pagerTitleStrip.setViewPager(materialViewPager.viewPager)

    }


    class ForumMainPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

        var titles : ArrayList<String> = arrayListOf("GRAFOS", "ESTRUTURAS")

        override fun getPageTitle(position: Int): CharSequence? {
            return titles[position]
        }

        override fun getItem(position: Int): androidx.fragment.app.Fragment {
            if(position == 0)
                return GraphSection.newInstance()
            return DataStructuresSection.newInstance()
        }

        override fun getCount(): Int {
            return titles.size
        }
    }


}
