package com.akash.weather.repo.network.model

import com.google.gson.annotations.SerializedName

/**
 * @author Akash Patra
 */
class WeatherDetailInfo(
    @SerializedName("id")
    val id: Int,
    @SerializedName("main")
    val name: String,
    @SerializedName("description")
    val desc: String
)

class TemperatureDetailInfo(
    @SerializedName("temp")
    val temp: Float,
    @SerializedName("temp_min")
    val min: Float,
    @SerializedName("temp_max")
    val max: Float,
    @SerializedName("sea_level")
    val night: Float,
    @SerializedName("grnd_level")
    val eve: Float,
    @SerializedName("humidity")
    val morn: Float
)

class PerDayInfo(
    @SerializedName("dt")
    val date: Long,
    @SerializedName("main")
    val temp: TemperatureDetailInfo,
    @SerializedName("weather")
    val weatherList: List<WeatherDetailInfo>
)

class CityInfo(
    @SerializedName("name")
    val cityName: String
)

class WeatherResponse(
    @SerializedName("cod")
    val status: String,
    @SerializedName("message")
    val message: Int,
    @SerializedName("city")
    val city: CityInfo,
    @SerializedName("list")
    val forecastList: List<PerDayInfo>
)