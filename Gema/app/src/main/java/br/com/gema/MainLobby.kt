package br.com.gema

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import br.com.gema.Account.ProfileManageArea
import br.com.gema.Fragments.Chat.ChatHall
import br.com.gema.Fragments.Community.Forum.Management.NewPublicationArea
import br.com.gema.Fragments.Community.Forum.Sections.DataStructuresSection
import br.com.gema.Fragments.Community.Forum.Sections.GraphSection
import br.com.gema.Fragments.Community.ForumMain
import br.com.gema.Fragments.Hall.NotificationsArea
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener
import kotlinx.android.synthetic.main.activity_main_lobby.*
import kotlinx.android.synthetic.main.navigation_view_header.*

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
                replaceFragment(ForumMain.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            else -> {
                replaceFragment(ProfileManageArea.newInstance())
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
