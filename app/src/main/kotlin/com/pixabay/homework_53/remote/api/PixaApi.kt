package com.pixabay.homework_53.remote.api

import com.pixabay.homework_53.data.model.PixaModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PixaApi {
    @GET("api/")
    fun searchImage(
        @Query("q") keyWord: String,
        @Query("key") key: String = "32699766-90137d876055bfc7a983c779e"
        ): Call<PixaModel>

}