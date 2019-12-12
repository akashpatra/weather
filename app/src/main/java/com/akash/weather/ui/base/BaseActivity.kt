package com.akash.weather.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.akash.weather.WeatherApplication
import com.akash.weather.di.component.ActivityComponent
import com.akash.weather.di.component.DaggerActivityComponent
import com.akash.weather.di.module.ActivityModule

/**
 * Base Activity for the App. It handles creating different components of the App.
 *
 * @author Akash Patra
 */
open class BaseActivity : AppCompatActivity() {

    private lateinit var mActivityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mActivityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .applicationComponent((application as WeatherApplication).getComponent())
            .build()
    }

    fun getActivityComponent(): ActivityComponent {
        return mActivityComponent
    }
}
