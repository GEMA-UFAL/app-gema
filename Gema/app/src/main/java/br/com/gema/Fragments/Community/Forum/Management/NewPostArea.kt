package br.com.gema.Fragments.Community.Forum.Management

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.gema.R

class NewPostArea : AppCompatActivity() {

    companion object {
        fun getLaunchIntent(context: Context) = Intent(context, NewPostArea::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_post_area)
    }
}
