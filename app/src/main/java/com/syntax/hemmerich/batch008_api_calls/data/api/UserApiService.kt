package com.syntax.hemmerich.batch008_api_calls.data.api

import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import com.syntax.hemmerich.batch008_api_calls.data.model.User
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET

val BASE_URL = "https://gorest.co.in/public/v2/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface UserApiService {
    @GET("users")
    suspend fun getUsers():List<User>
}

object  UserApi {
    val retrofitService: UserApiService by lazy { retrofit.create(UserApiService::class.java) }
}