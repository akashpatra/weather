package com.akash.weather.ui;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.Map;

import javax.inject.Provider;

/**
 * @author Akash Patra
 */
public class WeatherViewModelFactory implements ViewModelProvider.Factory {

    private final String CLASS_NAME = this.getClass().getSimpleName();

    private final Map<Class<? extends ViewModel>, Provider<ViewModel>> mProviderMap;

    public WeatherViewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> providerMap) {
        this.mProviderMap = providerMap;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) mProviderMap.get(modelClass).get();
    }
}
