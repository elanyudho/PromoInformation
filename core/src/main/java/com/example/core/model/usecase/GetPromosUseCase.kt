package com.example.core.model.usecase

import com.example.core.model.model.Promo
import com.example.core.model.repository.PromoRepository
import com.example.core.util.exception.Failure
import com.example.core.util.vo.Either
import com.example.core.abstraction.UseCase
import javax.inject.Inject

class GetPromosUseCase @Inject constructor(private val repo: PromoRepository): UseCase<List<Promo>, UseCase.None>(){

    override suspend fun run(params: None): Either<Failure, List<Promo>> {
        return repo.getPromos()
    }
}