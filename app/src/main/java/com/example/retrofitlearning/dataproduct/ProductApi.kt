package com.example.retrofitlearning.dataproduct

import com.example.retrofitlearning.datauser.DataPostUser
import com.example.retrofitlearning.datauser.UserData
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ProductApi {
    @GET("products/{ident}")
    suspend fun getProduct(@Path("ident") id:Int):ProductData

    @POST("auth/login")
    suspend fun auth(@Body authRequest:DataPostUser):UserData
}