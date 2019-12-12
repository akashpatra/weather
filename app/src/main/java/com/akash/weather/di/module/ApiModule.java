package com.akash.weather.di.module;

import com.akash.weather.repo.network.ApiHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Dagger Module for Network APIs using Retrofit Library.
 *
 * @author Akash Patra
 */
@Module
public class ApiModule {

    @Singleton
    @Provides
    ApiHelper provideWeatherApiService(Retrofit retrofit) {
        return retrofit.create(ApiHelper.class);
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(String baseUrl, Converter.Factory converterFactory,
                             CallAdapter.Factory callAdapterFactory, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(callAdapterFactory)
                .client(okHttpClient)
                .build();
    }

    @Singleton
    @Provides
    Converter.Factory provideGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Singleton
    @Provides
    CallAdapter.Factory provideRxJavaCallAdapter() {
        return RxJava2CallAdapterFactory.create();
    }
}
