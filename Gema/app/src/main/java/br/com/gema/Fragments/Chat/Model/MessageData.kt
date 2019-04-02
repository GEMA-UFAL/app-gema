package br.com.gema.Fragments.Chat.Model


import androidx.fragment.app.FragmentActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.firebase.auth.FirebaseAuth

class MessageData(
    val userId : String = "",
    val text : String = "",
    val imageUrl : String = "") {

    constructor() : this("", "", "")


}