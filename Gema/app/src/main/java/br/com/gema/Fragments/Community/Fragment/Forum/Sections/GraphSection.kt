package br.com.gema.Fragments.Community.Fragment.Forum.Sections


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.gema.Fragments.Community.Model.ForumPost
import br.com.gema.Fragments.Community.Handler.ForumPostHolder

import br.com.gema.R
import com.github.florent37.materialviewpager.MaterialViewPagerHelper
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_graph_section.*

class GraphSection : androidx.fragment.app.Fragment() {

    private var adapter = GroupAdapter<ViewHolder>()

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

        var tsp = ForumPost.Builder().title("").alternativeTitle("").imageUrl("").tag1("").tag2("").description("").build()
        var mcmf = ForumPost.Builder().title("").alternativeTitle("").imageUrl("").tag1("").tag2("").description("").build()
        var mvc = ForumPost.Builder().title("").alternativeTitle("").imageUrl("").tag1("").tag2("").description("").build()

        adapter.add(ForumPostHolder(tsp))
        adapter.add(ForumPostHolder(tsp))
        adapter.add(ForumPostHolder(tsp))

        graph_section_recycler_view.adapter = adapter
    }

}
