package com.okcodex.trymvc.common.dependencyinjection

import android.content.Context
import com.google.gson.GsonBuilder
import com.okcodex.trymvc.common.Constants
import com.okcodex.trymvc.networking.PostService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class CompositionRoot {

    private lateinit var mRetrofit: Retrofit

    private fun getRetrofit(): Retrofit {
        if (!this::mRetrofit.isInitialized) {
            mRetrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient()).build()
        }
        return mRetrofit
    }

    private fun <T> buildService(service: Class<T>): T {
        return getRetrofit().create(service)
    }

    private fun okHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
        return okHttpClient.build()
    }

    fun getPostService(): PostService {
        return buildService(PostService::class.java)
    }

}