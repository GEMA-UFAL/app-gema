package br.com.gema.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import br.com.gema.Login.Handler.GoogleLoginHandler
import br.com.gema.Activities.MainLobby
import br.com.gema.R


open class LoginLobby : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        // Display activity on screen


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_lobby)

        //startActivity(MainLobby.getLaunchIntent(this))
        //Assign functions to UI elements
        setupUI()

    }

    private fun setupUI() {
        setupLogInButton(R.id.login_google_image, GoogleLoginHandler.getLaunchIntent(this))
        //setupLogInButton(R.id.login_facebook_image, FacebookLoginHandler.getLaunchIntent(this))
        //setupLogInButton(R.id.login_twitter_image, TwitterLoginHandler.getLaunchIntent(this))
    }

    private fun setupLogInButton(id: Int, intent: Intent) {
        var signInButton = findViewById<View>(id) as ImageButton
        signInButton.setOnClickListener {
            startActivity(intent)
        }
    }

}