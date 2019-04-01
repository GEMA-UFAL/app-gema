package br.com.gema.Account

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.gema.R
import com.bumptech.glide.Glide
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_profile_manage_area.*
import kotlinx.android.synthetic.main.owner_chat_message_holder.view.*

class ProfileManageArea : androidx.fragment.app.Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = ProfileManageArea()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_manage_area, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }


    private fun setupUI() {
        var account : GoogleSignInAccount = GoogleSignIn.getLastSignedInAccount(activity)!!

        profile_area_user_name.text = account.displayName

        Picasso.get().load(account.photoUrl.toString()).into(profile_area_user_image)
    }

}
