package com.example.core.data.remote.source

import com.example.core.data.remote.response.PromoResponse
import com.example.core.data.remote.service.ApiService
import com.example.core.util.exception.Failure
import com.example.core.util.vo.Either
import javax.inject.Inject

class RemoteDataSource
@Inject constructor(private val api: ApiService) : RemoteSafeRequest() {

    suspend fun getPromos(): Either<Failure, PromoResponse> =
        request {
            api.getPromos()
        }
}