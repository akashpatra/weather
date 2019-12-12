package com.akash.weather.di.component

import android.content.Context
import com.akash.weather.di.module.ApiModule
import com.akash.weather.di.module.ApplicationModule
import com.akash.weather.di.module.HttpClientModule
import com.akash.weather.di.scope.ApplicationContext
import com.akash.weather.repo.network.ApiHelper
import dagger.Component
import javax.inject.Singleton

/**
 * @author Akash Patra
 */
@Singleton
@Component(modules = [ApplicationModule::class, HttpClientModule::class, ApiModule::class])
interface ApplicationComponent {
    fun api(): ApiHelper

    @ApplicationContext
    fun context(): Context

}
