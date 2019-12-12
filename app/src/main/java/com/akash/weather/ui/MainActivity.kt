package com.akash.weather.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.akash.weather.R
import com.akash.weather.ui.base.BaseActivity
import com.akash.weather.ui.weather.WeatherFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment(WeatherFragment.newInstance())
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun addFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().add(R.id.fragContainer, fragment)
            .commitAllowingStateLoss()
    }
}
