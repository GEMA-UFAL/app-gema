package br.com.gema.Fragments.Community.Forum.Sections


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.gema.R
import com.github.florent37.materialviewpager.MaterialViewPager
import com.github.florent37.materialviewpager.MaterialViewPagerHelper
import kotlinx.android.synthetic.main.fragment_graph_section.*

class GraphSection : androidx.fragment.app.Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() : GraphSection {
            return GraphSection()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_graph_section, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        MaterialViewPagerHelper.registerScrollView(activity, graph_section_nested_scroll_view)
    }

}
