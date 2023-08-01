package com.example.core.data.repository

import com.example.core.data.remote.mapper.PromosMapper
import com.example.core.data.remote.source.RemoteDataSource
import com.example.core.model.model.Promo
import com.example.core.model.repository.PromoRepository
import com.example.core.util.exception.Failure
import com.example.core.util.vo.Either
import javax.inject.Inject

class PromoRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val promoMapper: PromosMapper,
) : PromoRepository {

    override suspend fun getPromos(): Either<Failure, List<Promo>> {
        return when (val response = remoteDataSource.getPromos()) {
            is Either.Success -> {
                val data = promoMapper.mapToDomain(response.body)
                Either.Success(data)
            }
            is Either.Error -> {
                Either.Error(response.failure)
            }
        }
    }
}