package br.com.gema.Fragments.Community.Handler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.gema.R


class NewPublicationArea : androidx.fragment.app.Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = NewPublicationArea()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_publication_area, container, false)
    }

}
