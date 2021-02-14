package com.example.appnexttestapp

import com.example.appnexttestapp.NetworkingConstants.BASE_URL
import retrofit2.Call
import retrofit2.http.GET

interface AppsListService {

    @GET(BASE_URL)
    fun loadAppList(): Call<AppsListResult>



}