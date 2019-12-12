package com.akash.weather.di.module;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Dependency related to OkHttp and HttpClient
 *
 * @author Akash Patra
 */
@Module
public class HttpClientModule {

    @Singleton
    @Provides
    OkHttpClient providesOkHttp(@Named("connectionTimeoutInSeconds") int connectionTimeOut,
                                @Named("readTimeoutInSeconds") int readTimeOut,
                                boolean isDebug,
                                HttpLoggingInterceptor loggingInterceptor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(connectionTimeOut, TimeUnit.SECONDS)
                .readTimeout(readTimeOut, TimeUnit.SECONDS);

        if (isDebug) {
            builder.addInterceptor(loggingInterceptor);
        }
        return builder.build();
    }

    @Singleton
    @Provides
    HttpLoggingInterceptor providesLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return logging;
    }
}
