package com.akash.weather.di.module;

import android.app.Application;
import android.content.Context;

import com.akash.weather.BuildConfig;
import com.akash.weather.di.scope.ApplicationContext;
import com.akash.weather.repo.network.NetworkConstants;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dependency Module for Application
 *
 * @author Akash Patra
 */
@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Singleton
    @Provides
    boolean provideIsDebug() {
        return BuildConfig.DEBUG;
    }

    @Singleton
    @Provides
    String provideBaseUrl() {
        return BuildConfig.BASE_URL;
    }

    @Singleton
    @Provides
    @Named("connectionTimeoutInSeconds")
    int provideConnectionTimeOutInSeconds() {
        return NetworkConstants.CONNECTION_TIME_OUT;
    }

    @Singleton
    @Provides
    @Named("readTimeoutInSeconds")
    int provideReadTimeOutInSeconds() {
        return NetworkConstants.READ_TIME_OUT;
    }

    @Singleton
    @Provides
    @Named("apiKey")
    String provideApiKey() {
        return NetworkConstants.API_KEY;
    }
}
