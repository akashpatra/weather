package com.akash.weather.repo.network

import com.akash.weather.repo.network.model.WeatherResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * API's related to Weather App. These are the api's which are using Retrofit Library.
 *
 * @author Akash Patra
 */
interface ApiHelper {

    // Headlines
    @GET("data/2.5/forecast")
    fun fetchWeatherForecast(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("cnt") days: String
    ): Single<WeatherResponse>
}
