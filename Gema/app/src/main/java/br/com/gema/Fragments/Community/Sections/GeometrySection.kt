package br.com.gema.Fragments.Community.Sections

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.gema.R

// TODO: Rename parameter arguments, choose names that match
class GeometrySection : androidx.fragment.app.Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = GeometrySection()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_geometry_section, container, false)
    }

}
