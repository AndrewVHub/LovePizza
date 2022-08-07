package com.example.makepizza.di

import com.example.makepizza.BuildConfig
import com.example.makepizza.data.network.ApiWorker
import com.example.makepizza.data.network.ApiWorkerImpl
import com.example.makepizza.data.network.AppService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModules {

    @Provides
    @Singleton
    fun provideApiService(): AppService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(AppService::class.java)
    }

    @Provides
    @Singleton
    fun provideApiWorker(apiService: AppService): ApiWorker {
        return ApiWorkerImpl(apiService)
    }
}