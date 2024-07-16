package com.example.intentapp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvResult: TextView

    //    Untuk membuat activity dapat mengembalikanb nilai
    private val resultLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == MoveForResultActivity.RESULT_CODE && result.data != null) {
            val selectedValue =
                result.data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
            tvResult.text = "Hasil : $selectedValue"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        val btnMoveWithObject: Button = findViewById(R.id.btn_move_activity_object)
        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        val btnMoveForResult: Button = findViewById(R.id.btn_move_for_result)
        tvResult = findViewById(R.id.tv_result)
        btnMoveActivity.setOnClickListener(this)
        btnMoveWithDataActivity.setOnClickListener(this)
        btnMoveWithObject.setOnClickListener(this)
        btnDialPhone.setOnClickListener(this)
        btnMoveForResult.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }

            R.id.btn_move_activity_data -> {
                val moveWithDataActivity =
                    Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithDataActivity.putExtra(MoveWithDataActivity.EXTRA_NAME, "Lulut")
                moveWithDataActivity.putExtra(MoveWithDataActivity.EXTRA_AGE, 12)
                startActivity(moveWithDataActivity)
            }

            R.id.btn_move_activity_object -> {
                val person = Person("Lulut", 12, "email@email.com", "Pekanbaru")

                val moveWithObjectIntent =
                    Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)
            }

            R.id.btn_dial_number -> {
                val phoneNumber = "0821271230837"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }

            R.id.btn_move_for_result -> {
                val moveForResultIntent =
                    Intent(this@MainActivity, MoveForResultActivity::class.java)
                // Perbedaan dengan intent biasa yaitu menggunakan launch
                resultLauncher.launch(moveForResultIntent)
            }


        }
    }
}