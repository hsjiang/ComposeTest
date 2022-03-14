package com.hsjiang.library.di

import android.annotation.SuppressLint
import android.app.Application
import com.hsjiang.library.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.security.SecureRandom
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import javax.net.ssl.*

@Module
@InstallIn(SingletonComponent::class)
class HttpModule {

    @Provides
    @Singleton
    fun provideOkhttpClient(application: Application): OkHttpClient {
        return okHttpClientBuilder(application).build()
    }

    private fun okHttpClientBuilder(application: Application): OkHttpClient.Builder {
        val builder = OkHttpClient.Builder()

        builder.connectTimeout((20 * 1000).toLong(), TimeUnit.MILLISECONDS)
            .writeTimeout((20 * 1000).toLong(), TimeUnit.MILLISECONDS)
            .readTimeout((20 * 1000).toLong(), TimeUnit.MILLISECONDS)

        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(logging)
        }

        builder.cache(cache(application))
        val sslFactory = createSSLSocketFactory()
        sslFactory?.let { builder.sslSocketFactory(it, TrustAllManager()) }
        builder.hostnameVerifier(TrustAllHostnameVerifier())

        return builder
    }

    private fun cache(application: Application): Cache {
        val cacheSize = 20 * 1024 * 1024 // 20 MiB
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    @SuppressLint("TrulyRandom")
    private fun createSSLSocketFactory(): SSLSocketFactory? {

        var sSLSocketFactory: SSLSocketFactory? = null

        try {
            val sc = SSLContext.getInstance("TLS")
            sc.init(null, arrayOf<TrustManager>(TrustAllManager()), SecureRandom())
            sSLSocketFactory = sc.socketFactory
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return sSLSocketFactory
    }

    private class TrustAllManager : X509TrustManager {

        override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {

        }

        override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {

        }

        override fun getAcceptedIssuers(): Array<X509Certificate> {
            return arrayOf()
        }
    }

    private class TrustAllHostnameVerifier : HostnameVerifier {
        override fun verify(hostname: String?, session: SSLSession?): Boolean {
            return true
        }
    }
}