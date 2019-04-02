package br.com.gema.Login.Handler

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import br.com.gema.Activities.MainLobby
import br.com.gema.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class GoogleLoginHandler : AppCompatActivity() {

    companion object {
        fun getLaunchIntent(context: Context) = Intent(context, GoogleLoginHandler::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }

    private lateinit var firebaseAuth : FirebaseAuth
    private lateinit var signInOptions : GoogleSignInOptions
    private lateinit var signInClient : GoogleSignInClient
    private enum class Status {SUCCESS, FAILURE}

    override fun onCreate(savedInstanceState: Bundle?) {
        //Sign out if already logged in
        firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth.signOut()


        // Display activity on screen
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_login_area)

        configureSignIn()
        launchSignIn()
    }



    private fun configureSignIn() {
        //Configure google sign-in options from google login SDK
        signInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        //Configure google sign-in client
        signInClient = GoogleSignIn.getClient(this, signInOptions)
    }

    private fun launchSignIn() {
        var signInIntent : Intent = signInClient.signInIntent
        startActivityForResult(signInIntent, Status.SUCCESS.ordinal)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == Status.SUCCESS.ordinal) {
            val task : Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                tryLogIn(account!!)
            } catch (e : ApiException) {
                Toast.makeText(this, "Exc", Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }

    private fun tryLogIn(account : GoogleSignInAccount) {
        firebaseAuth = FirebaseAuth.getInstance()
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener {
            if(it.isSuccessful) {
                Toast.makeText(this, "Logged", Toast.LENGTH_LONG).show()
                startActivity(MainLobby.getLaunchIntent(this))

            } else {
                Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }


}
