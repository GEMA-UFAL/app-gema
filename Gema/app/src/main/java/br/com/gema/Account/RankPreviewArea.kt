package br.com.gema.Account

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.gema.R

class RankPreviewArea : AppCompatActivity() {

    companion object {
        @JvmStatic
        fun newInstance() = RankPreviewArea()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rank_preview_area)
    }
}
