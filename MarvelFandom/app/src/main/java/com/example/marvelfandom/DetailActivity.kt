@file:Suppress("DEPRECATION")

package com.example.marvelfandom

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    lateinit var dataMarvel: Marvel;

    companion object {
        const val MARVEL_DATA = "marvel"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val ivAvatar: ImageView = findViewById(R.id.iv_avatar)
        val tvName: TextView = findViewById(R.id.tv_detail_name)
        val tvAliases: TextView = findViewById(R.id.tv_detail_aliases)
        val tvDesc: TextView = findViewById(R.id.tv_detail_desc)
        val tvCategory: TextView = findViewById(R.id.tv_detail_category)
        val tvAge: TextView = findViewById(R.id.tv_detail_age)
        val tvHistory: TextView = findViewById(R.id.tv_detail_history)

        val dataMarvel = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(MARVEL_DATA, Marvel::class.java)
        } else {
            intent.getParcelableExtra(MARVEL_DATA)
        }

        if (dataMarvel != null) {
            val actionBar = supportActionBar
            actionBar?.title = dataMarvel.name

            Glide.with(this).load(dataMarvel.photo).into(ivAvatar)
            tvName.text = dataMarvel.name
            tvAliases.text = dataMarvel.alias
            tvCategory.text = dataMarvel.category
            tvDesc.text = dataMarvel.description
            tvAge.text = dataMarvel.age.toString()
            tvHistory.text = dataMarvel.history


        }

        val btnShare: Button = findViewById(R.id.action_share)
        btnShare.setOnClickListener {
            shareMarvelData(dataMarvel)
        }

//        Log.d("marvel", dataMarvel?.name.toString())
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
        }
        return super.onOptionsItemSelected(item)
    }

    private fun shareMarvelData(dataMarvel: Marvel?) {
        if (dataMarvel != null) {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(
                    Intent.EXTRA_TEXT,
                    "cek Marvel character this out :\n${dataMarvel.name}\n\n${dataMarvel.description}"
                )
            }
            startActivity(Intent.createChooser(shareIntent, "Share Marvel Fandom"))
        }
    }
}