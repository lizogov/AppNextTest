package com.example.appnexttestapp

import com.example.appnexttestapp.NetworkingConstants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RestClient {

    val APPS_LIST_SERVICE: AppsListService by lazy {
        val retrofit = createRetrofitClient()
        retrofit.create(AppsListService::class.java)
    }

    private fun createRetrofitClient() = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}