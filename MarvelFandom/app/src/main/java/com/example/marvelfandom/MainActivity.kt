package com.example.marvelfandom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvMarvels: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setup RecyclerView
        rvMarvels = findViewById(R.id.rvMarvels)
        rvMarvels.setHasFixedSize(true)

        showRecyclerView()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
            }

            R.id.share_action -> {
                shareApp()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun shareApp() {

        val shareText = "Yuk cek favorit karakter Marvel mu: di MarvelFandom"

        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareText)

        startActivity(Intent.createChooser(shareIntent, "Bagikan karakter Marvel sekarang"))
    }

    private fun showRecyclerView() {
        rvMarvels.layoutManager = LinearLayoutManager(this)
        val listMarvelsAdapter = ListMarvelAdapter(marvelList)
        rvMarvels.adapter = listMarvelsAdapter
    }
}