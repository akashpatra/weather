package com.akash.weather.ui.base

import androidx.lifecycle.ViewModel
import com.akash.weather.exceptions.ApiResponseException
import com.akash.weather.exceptions.EmptyResultException
import java.net.ConnectException
import java.net.SocketTimeoutException

/**
 * @author Akash Patra
 */
open class BaseViewModel : ViewModel() {

    protected fun getMsg(t: Throwable): String {
        return when (t) {
            is ApiResponseException -> t.message ?: ""
            is EmptyResultException -> "Sorry! We were unable to fetch details. Please check internet connection and try again. EC: no data."
            is ConnectException -> "Sorry! We were unable to fetch details. Please check internet connectivity and try again. EC: request timeout."
            is SocketTimeoutException -> "Sorry! We were unable to fetch details. Please check internet connection and try again. EC: server timeout."
            else -> "Sorry! We were unable to proceed. Please check internet connection and try again. EC: exception."
        }
    }
}
