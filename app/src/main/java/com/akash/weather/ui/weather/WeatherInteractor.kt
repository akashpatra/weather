package com.akash.weather.ui.weather

import com.akash.weather.repo.network.model.WeatherResponse
import com.akash.weather.ui.base.BaseInteractor

/**
 * @author Akash Patra
 */
interface WeatherInteractor : BaseInteractor {

    fun fetchTopHeadlines(
        responseListener: BaseInteractor.IResponseListener<WeatherResponse>
    )
}