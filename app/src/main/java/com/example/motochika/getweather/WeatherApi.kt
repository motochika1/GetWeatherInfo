package com.example.motochika.getweather

import com.example.motochika.getweather.api.WeatherInfo
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("/forecast/webservice/json/v1")
    suspend fun getWeaterInfo(                //"forecast/webservice/json/v1"にGETリクエストをする関数
        @Query("city")
        city: String
    ): WeatherInfo
}