package br.com.gema.Fragments.Community.Forum.Sections

import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.gema.R
import com.github.florent37.materialviewpager.MaterialViewPagerHelper
import kotlinx.android.synthetic.main.fragment_data_structures_section.*
import kotlinx.android.synthetic.main.fragment_graph_section.*


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [DataStructuresSection.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [DataStructuresSection.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class DataStructuresSection : androidx.fragment.app.Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = DataStructuresSection()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data_structures_section, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        MaterialViewPagerHelper.registerScrollView(activity, data_structures_section_nested_scroll_view)
    }

}
