package com.akash.weather.ui.base

/**
 * @author Akash Patra
 */
interface BaseInteractor {

    fun unbind()

    interface IResponseListener<T> {
        fun onProgress()

        fun onSuccess(resp: T)

        fun onFailure(t: Throwable)
    }
}
