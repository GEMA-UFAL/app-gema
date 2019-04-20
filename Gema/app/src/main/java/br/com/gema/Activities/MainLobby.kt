package br.com.gema.Activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import br.com.gema.Fragments.Account.ProfileHall
import br.com.gema.Fragments.Chat.ChatHall
import br.com.gema.Fragments.Community.Handler.NewPublicationArea
import br.com.gema.Fragments.Community.ForumHall
import br.com.gema.Fragments.Community.Sections.ExamplePost
import br.com.gema.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main_lobby.*
import kotlinx.android.synthetic.main.navigation_view_header.view.*

class MainLobby : AppCompatActivity() {

    private lateinit var bottomNavigation: BottomNavigationView
    private val navigationItemSelectedListener = OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.inicio -> {
                replaceFragment(NewPublicationArea.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.chat -> {
                replaceFragment(ChatHall.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.forum -> {
                replaceFragment(ExamplePost.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            else -> {
                replaceFragment(ProfileHall.newInstance())
                return@OnNavigationItemSelectedListener true
            }
        }
    }

    companion object {
        fun getLaunchIntent(context: Context) = Intent(context, MainLobby::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_lobby)
    }

    override fun onStart() {
        super.onStart()

        var account : GoogleSignInAccount = GoogleSignIn.getLastSignedInAccount(this)!!

        navigation_view.inflateHeaderView(R.layout.navigation_view_header)

        navigation_view.getHeaderView(0).navigation_view_name.text = account.displayName.toString()
        navigation_view.getHeaderView(0).navigation_view_email.text = account.email.toString()
        Picasso.get().load(account.photoUrl.toString()).into(navigation_view.getHeaderView(0).navigation_image_view)

        bottomNavigation = bottom_navigation
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener)
        replaceFragment(NewPublicationArea.newInstance())
    }

    fun replaceFragment(fragment: Fragment) {
        var fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main_lobby_main_container, fragment)
        fragmentTransaction.commit()
    }

}
