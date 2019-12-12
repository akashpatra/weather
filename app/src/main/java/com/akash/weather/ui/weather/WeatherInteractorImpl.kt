package com.akash.weather.ui.weather

import com.akash.weather.exceptions.ApiResponseException
import com.akash.weather.repo.network.ApiHelper
import com.akash.weather.repo.network.model.WeatherResponse
import com.akash.weather.ui.base.BaseInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * Interactor for Weather Flow. Business Validation Logic is present in this layer.
 *
 * @author Akash Patra
 */
class WeatherInteractorImpl @Inject constructor(
    private val apiHelper: ApiHelper
) : WeatherInteractor {

    private val className = WeatherInteractorImpl::class.simpleName

    private lateinit var disposable: Disposable

    override fun fetchTopHeadlines(
        responseListener: BaseInteractor.IResponseListener<WeatherResponse>
    ) {
        // Show Progress
        responseListener.onProgress()

        disposable =
            apiHelper.fetchWeatherForecast("München,DE", "b6907d289e10d714a6e88b30761fae22", "8")
                .map { resp ->
                    if ("200" == resp.status) {
                        Timber.d("$className >> fetchWeatherForecast>> Resp: $resp")
                        resp
                    } else {
                        throw ApiResponseException(1001, "")
                    }
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseListener::onSuccess, responseListener::onFailure)
    }

    override fun unbind() {
        disposable.dispose()
    }
}
