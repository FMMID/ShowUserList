package com.app.showlistapp.data.network

import com.google.gson.GsonBuilder
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitProvider {

    fun get(): Retrofit = RetrofitFactory().createRetrofit()
}

class RetrofitFactory {

    private val baseUrl: HttpUrl by lazy {
        HttpUrl.Builder()
            .scheme(SCHEME)
            .host(HOST)
            .encodedPath(ENCODED_PATH)
            .build()
    }

    fun createRetrofit(): Retrofit {

        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val gson = GsonBuilder()
            .setLenient()
            .create()


        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    companion object {
        private const val SCHEME = "https"
        private const val HOST = "datausa.io"
        private const val ENCODED_PATH = "/api/"
    }
}

internal inline fun <reified T> createApi(retrofitProvider: RetrofitProvider): T {
    return retrofitProvider.get().create(T::class.java)
}