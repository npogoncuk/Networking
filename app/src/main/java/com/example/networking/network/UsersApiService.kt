package com.example.networking.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://randomuser.me"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val client = OkHttpClient.Builder()
    .addInterceptor(HttpLoggingInterceptor())
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))    //ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .client(client.build())
    .build()

interface ResultsApiService {
    @GET("/api?page=3&results=10")
    suspend fun getJson(): ReceivedJSON
}

object ResultsApi {
    val retrofitService: ResultsApiService by lazy {
        retrofit.create(ResultsApiService::class.java)
    }
}