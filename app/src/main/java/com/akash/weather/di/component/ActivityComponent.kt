package com.akash.weather.di.component

import com.akash.weather.di.module.ActivityModule
import com.akash.weather.di.scope.Activity
import com.akash.weather.ui.weather.WeatherFragment
import dagger.Component

/**
 * Dagger Component Related to Activity
 *
 * @author Akash Patra
 */
@Activity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(frag: WeatherFragment)
}
