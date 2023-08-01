package com.example.core.model.repository

import com.example.core.model.model.Promo
import com.example.core.util.exception.Failure
import com.example.core.util.vo.Either

interface PromoRepository {

    suspend fun getPromos(): Either<Failure, List<Promo>>

}