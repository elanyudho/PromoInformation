package com.example.core.data.remote.service

import com.example.core.data.remote.response.PromoResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("promos")
    suspend fun getPromos(): Response<PromoResponse>
}