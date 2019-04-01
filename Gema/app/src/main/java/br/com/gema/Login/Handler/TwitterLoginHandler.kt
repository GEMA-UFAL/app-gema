package br.com.gema.Login.Handler

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.gema.R
import com.google.firebase.auth.FirebaseAuth

class TwitterLoginHandler : AppCompatActivity() {

    companion object {
        fun getLaunchIntent(context: Context) = Intent(context, TwitterLoginHandler::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }

    private lateinit var firebaseAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        // Display activity on screen
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_lobby)
    }
}