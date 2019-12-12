package com.akash.weather.ui.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.akash.weather.repo.network.model.PerDayInfo
import com.akash.weather.repo.network.model.WeatherResponse
import com.akash.weather.ui.base.BaseInteractor
import com.akash.weather.ui.base.BaseViewModel

/**
 * View Model for Weather Flow
 *
 * @author Akash Patra
 */
class WeatherViewModel(private val interactor: WeatherInteractor) : BaseViewModel() {

    private val className = WeatherViewModel::class.simpleName

    // Live Data
    private val commonViewStateMutableLiveData: MutableLiveData<WeatherUIState> = MutableLiveData()
    val commonViewStateLiveData: LiveData<WeatherUIState>
        get() = commonViewStateMutableLiveData

    /**
     * Fetch Forecast.
     */
    fun fetchForecast() {
        interactor.fetchTopHeadlines(
            object : BaseInteractor.IResponseListener<WeatherResponse> {

                override fun onProgress() {
                    // Notify progress State as visible
                    commonViewStateMutableLiveData.value = WeatherUIState.ShowProgress(true)
                }

                override fun onSuccess(resp: WeatherResponse) {
                    commonViewStateMutableLiveData.value =
                        WeatherUIState.WeatherResp(composeWeatherResp(resp.forecastList))

                    // Notify progress State as gone
                    commonViewStateMutableLiveData.value = WeatherUIState.ShowProgress(false)
                }

                override fun onFailure(t: Throwable) {
                    commonViewStateMutableLiveData.value = WeatherUIState.ShowSnackBar(getMsg(t))

                    // Notify progress State as gone
                    commonViewStateMutableLiveData.value = WeatherUIState.ShowProgress(false)
                }
            })
    }

    /**
     * Compose the required Weather Response to show in UI.
     */
    private fun composeWeatherResp(forecast: List<PerDayInfo>): List<ForecastUIModel> {
        val modifiedWeather = mutableListOf<ForecastUIModel>()
        for (perDayInfo in forecast) {
            perDayInfo.apply {
                modifiedWeather.add(
                    ForecastUIModel(
                        perDayInfo.date.toString(),
                        perDayInfo.temp.day.toString(),
                        perDayInfo.temp.min.toString(),
                        perDayInfo.temp.max.toString(),
                        perDayInfo.temp.night.toString(),
                        perDayInfo.temp.eve.toString(),
                        perDayInfo.temp.morn.toString(),
                        perDayInfo.weatherList[0].name
                    )
                )
            }
        }

        return modifiedWeather
    }

    override fun onCleared() {
        super.onCleared()
        interactor.unbind()
    }
}
