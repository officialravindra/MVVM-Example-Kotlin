package com.example.mvvmkotlinexample.retrofit

import com.example.mvvmkotlinexample.model.GetPlansResponse
import com.example.mvvmkotlinexample.model.ServicesSetterGetter
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("dummyAPi")
    fun getServices() : Call<ServicesSetterGetter>


    @GET("getPlans")
    fun getPlans(): Call<GetPlansResponse>

}