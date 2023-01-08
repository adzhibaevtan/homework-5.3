package com.pixabay.homework_53.remote.retrofit

import com.pixabay.homework_53.remote.api.PixaApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

    val retrofit = Retrofit.Builder().baseUrl("https://pixabay.com/").addConverterFactory(GsonConverterFactory.create()).build()
    var api = retrofit.create(PixaApi::class.java)
}