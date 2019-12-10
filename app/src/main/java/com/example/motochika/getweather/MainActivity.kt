package com.example.motochika.getweather

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getTodayButton?.setOnClickListener {
            val intent = Intent(this,Result::class.java)
            intent.putExtra("day","今日")

            Log.d("MainActivity: onCreate","Button Clicked")

            startActivity(intent)

        }

        getTomorrowButton?.setOnClickListener {
            val intent = Intent(this,Result::class.java)
            intent.putExtra("day","明日")

            Log.d("MainActivity: onCreate","Button Clicked")

            startActivity(intent)
        }

        getDATomorrowButton?.setOnClickListener {
            val intent = Intent(this,Result::class.java)

            intent.putExtra("day","明後日")

            Log.d("MainActivity: onCreate","Button Clicked")

            startActivity(intent)
        }

    }

}

