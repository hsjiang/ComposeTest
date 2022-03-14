package com.hsjiang.composetest.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Singleton
    @Provides
    fun retrofit4WorkApi(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return getRetrofit("https://cms-beta.51xuetang.com/", gson, okHttpClient)
    }

    private fun getRetrofit(url: String, gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().apply {
            addConverterFactory(GsonConverterFactory.create(gson))
            baseUrl(url)
            client(okHttpClient)
        }.build()
    }
}