package com.chores.gamede

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chores.gamede.data.GameData
import com.chores.gamede.data.GameDataObject
import com.chores.gamede.ui.DetailGameActivity
import com.chores.gamede.ui.ListGameAdapter
import com.chores.gamede.ui.ProfileActivity

class MainActivity : AppCompatActivity() {
    private lateinit var rvGame: RecyclerView
    private var list: ArrayList<GameData> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvGame = findViewById(R.id.rv_game)
        rvGame.setHasFixedSize(true)
        list.addAll(GameDataObject.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvGame.layoutManager = LinearLayoutManager(this)
        val listGameAdapter = ListGameAdapter(list)
        rvGame.adapter = listGameAdapter

        listGameAdapter.setOnItemClickCallback(object : ListGameAdapter.OnItemClickCallback {
            override fun onItemClickedData(data: GameData) {
                showSelectedGame(data)
            }

        })
    }

    private fun showSelectedGame(data: GameData) {
        val detailGameActivity =
            Intent(this@MainActivity, DetailGameActivity::class.java).apply {
                putExtra(DetailGameActivity.EXTRA_PHOTO, data.photo)
                putExtra(DetailGameActivity.EXTRA_GAME, data.name)
                putExtra(DetailGameActivity.EXTRA_PRODUCER, data.producer)
                putExtra(DetailGameActivity.EXTRA_DETAIL, data.details)
            }
        startActivity(detailGameActivity)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.btn_profile -> {
                val moveIntent = Intent(this@MainActivity, ProfileActivity::class.java)
                moveIntent.putExtra(ProfileActivity.EXTRA_PHOTO, R.drawable.propil)
                moveIntent.putExtra(ProfileActivity.EXTRA_NAME, "Ladyaris Khalishah")
                moveIntent.putExtra(ProfileActivity.EXTRA_LINK, "https://www.dicoding.com/users/led_ih")

                startActivity(moveIntent)
            }
        }
    }
}