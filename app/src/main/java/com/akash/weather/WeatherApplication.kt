package com.akash.weather

import android.app.Application
import com.akash.weather.di.component.ApplicationComponent
import com.akash.weather.di.component.DaggerApplicationComponent
import com.akash.weather.di.module.ApplicationModule
import com.akash.weather.utils.Constants
import timber.log.Timber

/**
 * Custom Application for the App.
 *
 * @author Akash Patra
 */
class WeatherApplication : Application() {

    private lateinit var mApplicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        mApplicationComponent =
            DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()

        // Initialize Timber for Debug Build
        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                override fun createStackElementTag(element: StackTraceElement): String {
                    return Constants.TAG
                }
            })
        }
    }

    fun getComponent(): ApplicationComponent {
        return mApplicationComponent
    }
}