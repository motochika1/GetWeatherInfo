package com.example.motochika.getweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.weather_result.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Result : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.weather_result)

        onParallelGetButtonClick()

        backButton?.setOnClickListener {

            finish()
            Log.d("WeatherResult", "Button Clicked")
        }

    }


    fun onParallelGetButtonClick() = lifecycleScope.launch {
        //メインスレッドで動かす
        val day = intent.getStringExtra("day")

        setWeatherText(day)
    }


    suspend fun setWeather(ID: String, Day: String) = withContext(Dispatchers.IO) {
        val http = HttpUtil()

        when (Day) {
            "今日" -> http.weatherApi().getWeaterInfo(ID).forecasts.find {
                it.dateLabel == "今日"
            }?.telop
            "明日" -> http.weatherApi().getWeaterInfo(ID).forecasts.find {
                it.dateLabel == "明日"
            }?.telop
            "明後日" -> http.weatherApi().getWeaterInfo(ID).forecasts.find {
                it.dateLabel == "明後日"
            }?.telop

            else -> "曜日なし"
        }

    }

    suspend fun setWeatherText(Day: String) {

        weather_result.setText(
            "札幌の${Day}の天気：" + setWeather("016010", Day) + "\n" +
                    "旭川の${Day}の天気：" + setWeather("012010", Day) + "\n" +
                    "函館の${Day}の天気：" + setWeather("017010", Day) + "\n" +
                    "仙台の${Day}の天気：" + setWeather("040010", Day) + "\n" +
                    "米沢の${Day}の天気：" + setWeather("060020", Day) + "\n" +
                    "新潟の${Day}の天気：" + setWeather("150010", Day) + "\n" +
                    "会津若松の${Day}の天気：" + setWeather("070030", Day) + "\n" +
                    "東京の${Day}の天気：" + setWeather("130010", Day) + "\n" +
                    "横浜の${Day}の天気：" + setWeather("140010", Day) + "\n" +
                    "名古屋の${Day}の天気：" + setWeather("230010", Day) + "\n" +
                    "大阪の${Day}の天気：" + setWeather("270000", Day) + "\n" +
                    "京都の${Day}の天気：" + setWeather("260010", Day) + "\n" +
                    "広島の${Day}の天気：" + setWeather("340010", Day) + "\n" +
                    "熊本の${Day}の天気：" + setWeather("430010", Day) + "\n"
        )

    }
}



