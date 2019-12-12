package com.akash.weather.ui.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.akash.weather.R
import com.akash.weather.ui.base.BaseActivity
import com.akash.weather.ui.base.BaseFragment
import com.akash.weather.ui.weather.adapter.ForecastRVAdapter
import kotlinx.android.synthetic.main.weather_fragment.*
import timber.log.Timber
import javax.inject.Inject

/**
 * Fragment to show Weather Forecast
 *
 * @author Akash Patra
 */
class WeatherFragment : BaseFragment() {

    private val className = WeatherFragment::class.simpleName

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private lateinit var viewModel: WeatherViewModel

    companion object {
        fun newInstance() = WeatherFragment()
    }

    override fun injectDependencies(baseActivity: BaseActivity?) {
        baseActivity?.getActivityComponent()?.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this, factory).get(WeatherViewModel::class.java)

        return inflater.inflate(R.layout.weather_fragment, container, false)
    }

    override fun setUp(view: View) {
        // Observers
        viewModel.commonViewStateLiveData.removeObservers(this)
        viewModel.commonViewStateLiveData.observe(this, Observer(this::handleCommonViewState))

        // Fetch Forecast
        viewModel.fetchForecast()
    }

    private fun handleCommonViewState(uiState: WeatherUIState) {
        Timber.d("$className >> handleCommonViewState >> ${uiState::class.simpleName}")

        when (uiState) {
            // Progress
            is WeatherUIState.ShowProgress -> {
                if (uiState.flag) {

                } else {

                }
            }

            // SnackBar
            is WeatherUIState.ShowSnackBar -> {
                showSnackBar(rvForecast, uiState.status)
            }

            // Headlines Resp
            is WeatherUIState.WeatherResp -> {
                val manager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                val adapter = ForecastRVAdapter(uiState.forecasts)

                rvForecast.layoutManager = manager
                rvForecast.adapter = adapter
            }
        }
    }

}
