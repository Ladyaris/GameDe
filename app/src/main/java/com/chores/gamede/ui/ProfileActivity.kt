package com.chores.gamede.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.chores.gamede.R

class ProfileActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_LINK = "extra_link"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        var actionBar = getSupportActionBar()
        actionBar?.setDisplayHomeAsUpEnabled(true)

        showUserActivity()
    }

    private fun showUserActivity() {
        val tvPhoto: ImageView = findViewById(R.id.cv_propil)
        val tvName: TextView = findViewById(R.id.tv_name)
        val tvLink: TextView = findViewById(R.id.tv_link)

        val photo = intent.getIntExtra(EXTRA_PHOTO, 0)
        val name = intent.getStringExtra(EXTRA_NAME)
        val link = intent.getStringExtra(EXTRA_LINK)

        tvPhoto.setImageResource(photo)
        tvName.setText("$name")
        tvLink.setText("$link")
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}