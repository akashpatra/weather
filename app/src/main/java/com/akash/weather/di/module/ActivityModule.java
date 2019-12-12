package com.akash.weather.di.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.akash.weather.di.scope.Activity;
import com.akash.weather.di.scope.ActivityContext;
import com.akash.weather.ui.WeatherViewModelFactory;
import com.akash.weather.ui.WeatherViewModelKey;
import com.akash.weather.ui.weather.WeatherInteractor;
import com.akash.weather.ui.weather.WeatherInteractorImpl;
import com.akash.weather.ui.weather.WeatherViewModel;

import java.util.Map;

import javax.inject.Provider;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

/**
 * Dependency Module for Activity
 *
 * @author Akash Patra
 */
@Module
public class ActivityModule {
    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    ViewModelProvider.Factory viewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> providerMap) {
        return new WeatherViewModelFactory(providerMap);
    }

    @Activity
    @Provides
    @IntoMap
    @WeatherViewModelKey(WeatherViewModel.class)
    ViewModel provideWeatherViewModel(WeatherInteractor interactor) {
        return new WeatherViewModel(interactor);
    }

    @Activity
    @Provides
    WeatherInteractor provideWeatherInteractor(WeatherInteractorImpl interactor) {
        return interactor;
    }
}
