package com.example.core.data.remote.mapper

import com.example.core.data.remote.response.PromoResponse
import com.example.core.model.model.Promo
import com.example.core.abstraction.BaseMapper

class PromosMapper : BaseMapper<PromoResponse, List<Promo>> {
    override fun mapToDomain(raw: PromoResponse): List<Promo> {
       return raw.map {
           Promo(it.nama, it.desc, it.lokasi, it.img?.url, it.createdAt )
       }
    }

    override fun mapToRaw(domain: List<Promo>): PromoResponse {
        return PromoResponse()
    }
}