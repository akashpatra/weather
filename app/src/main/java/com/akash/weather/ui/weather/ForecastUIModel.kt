package com.akash.weather.ui.weather

/**
 * @author Akash Patra
 */
sealed class WeatherUIState {
    data class ShowProgress(val flag: Boolean) : WeatherUIState()

    data class WeatherResp(val forecasts: List<ForecastUIModel>) : WeatherUIState()

    class ShowSnackBarRes(val strRes: Int) : WeatherUIState()

    class ShowSnackBar(val status: String) : WeatherUIState()
}

data class ForecastUIModel(
    val date: String,
    val dayTemp: String,
    val minTemp: String,
    val maxTemp: String,
    val nightTemp: String,
    val eveTemp: String,
    val mornTemp: String,
    val weatherDesc: String
)