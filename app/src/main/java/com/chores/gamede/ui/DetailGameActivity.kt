package com.chores.gamede.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.chores.gamede.R

class DetailGameActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_GAME = "extra_game"
        const val EXTRA_PRODUCER = "extra_producer"
        const val EXTRA_DETAIL = "extra_detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_game)

        var actionBar = getSupportActionBar()
        actionBar?.setDisplayHomeAsUpEnabled(true)

        showGameDetail()
    }

    private fun showGameDetail() {
        val tvImageReceived: ImageView = findViewById(R.id.iv_item_photo)
        val tvGameReceived: TextView = findViewById(R.id.tv_item_game)
        val tvProducerReceived: TextView = findViewById(R.id.tv_item_game_producer)
        val tvDetailReceived: TextView = findViewById(R.id.tv_item_game_details)

        val photo = intent.getIntExtra(EXTRA_PHOTO, 0)
        val game = intent.getStringExtra(EXTRA_GAME)
        val producer = intent.getStringExtra(EXTRA_PRODUCER)
        val detail = intent.getStringExtra(EXTRA_DETAIL)

        tvImageReceived.setImageResource(photo)
        tvGameReceived.setText("$game")
        tvProducerReceived.setText("$producer")
        tvDetailReceived.setText("$detail")
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}