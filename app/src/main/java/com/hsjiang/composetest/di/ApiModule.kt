package com.hsjiang.composetest.di

import com.hsjiang.composetest.api.WorkApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Singleton
    @Provides
    fun provideWorkApi(retrofit: Retrofit): WorkApi {
        return retrofit.create(WorkApi::class.java)
    }
}