package com.projects.citytask.di

import com.projects.citytask.data.remote.CityAPIServices
import com.projects.citytask.data.repository.CityRepositoryImpl
import com.projects.citytask.domain.repository.CityRepository
import com.projects.citytask.presentation.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CityModule {

    @Provides
    @Singleton
    fun provideInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor())
            .connectTimeout(20, TimeUnit.MILLISECONDS)
            .readTimeout(20, TimeUnit.MILLISECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideAPIService(): CityAPIServices {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CityAPIServices::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(cityAPIServices: CityAPIServices): CityRepository {
        return CityRepositoryImpl(cityAPIServices)
    }
}