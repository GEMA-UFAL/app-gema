package br.com.gema.Fragments.Chat.Handler


import androidx.fragment.app.FragmentActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.firebase.auth.FirebaseAuth

class MessageData(
    val userId : String = "",
    val text : String = "",
    val imageUrl : String = "") {

    constructor() : this("", "", "")

    constructor(text: String, activity : FragmentActivity) : this (FirebaseAuth.getInstance().uid.toString(), text,
        GoogleSignIn.getLastSignedInAccount(activity)!!.photoUrl.toString())

}