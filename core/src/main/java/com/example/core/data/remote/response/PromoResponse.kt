package com.example.core.data.remote.response


import com.google.gson.annotations.SerializedName

class PromoResponse : ArrayList<PromoResponse.PromoResponseItem>(){
    data class PromoResponseItem(
        @SerializedName("alt")
        val alt: String? = "",
        @SerializedName("count")
        val count: Int? = 0,
        @SerializedName("created_at")
        val createdat: String? = "",
        @SerializedName("createdAt")
        val createdAt: String? = "",
        @SerializedName("desc")
        val desc: String? = "",
        @SerializedName("desc_promo")
        val descPromo: Any? = Any(),
        @SerializedName("id")
        val id: Int? = 0,
        @SerializedName("img")
        val img: Img? = Img(),
        @SerializedName("latitude")
        val latitude: String? = "",
        @SerializedName("lokasi")
        val lokasi: String? = "",
        @SerializedName("longitude")
        val longitude: String? = "",
        @SerializedName("nama")
        val nama: String? = "",
        @SerializedName("name_promo")
        val namePromo: Any? = Any(),
        @SerializedName("published_at")
        val publishedAt: String? = "",
        @SerializedName("Title")
        val title: Any? = Any(),
        @SerializedName("updated_at")
        val updatedAt: String? = ""
    ) {
        data class Img(
            @SerializedName("alternativeText")
            val alternativeText: String? = "",
            @SerializedName("caption")
            val caption: String? = "",
            @SerializedName("created_at")
            val createdAt: String? = "",
            @SerializedName("ext")
            val ext: String? = "",
            @SerializedName("formats")
            val formats: Formats? = Formats(),
            @SerializedName("hash")
            val hash: String? = "",
            @SerializedName("height")
            val height: Int? = 0,
            @SerializedName("id")
            val id: Int? = 0,
            @SerializedName("mime")
            val mime: String? = "",
            @SerializedName("name")
            val name: String? = "",
            @SerializedName("previewUrl")
            val previewUrl: Any? = Any(),
            @SerializedName("provider")
            val provider: String? = "",
            @SerializedName("provider_metadata")
            val providerMetadata: Any? = Any(),
            @SerializedName("size")
            val size: Double? = 0.0,
            @SerializedName("updated_at")
            val updatedAt: String? = "",
            @SerializedName("url")
            val url: String? = "",
            @SerializedName("width")
            val width: Int? = 0
        ) {
            data class Formats(
                @SerializedName("large")
                val large: Large? = Large(),
                @SerializedName("medium")
                val medium: Medium? = Medium(),
                @SerializedName("small")
                val small: Small? = Small(),
                @SerializedName("thumbnail")
                val thumbnail: Thumbnail? = Thumbnail()
            ) {
                data class Large(
                    @SerializedName("ext")
                    val ext: String? = "",
                    @SerializedName("hash")
                    val hash: String? = "",
                    @SerializedName("height")
                    val height: Int? = 0,
                    @SerializedName("mime")
                    val mime: String? = "",
                    @SerializedName("name")
                    val name: String? = "",
                    @SerializedName("path")
                    val path: Any? = Any(),
                    @SerializedName("size")
                    val size: Double? = 0.0,
                    @SerializedName("url")
                    val url: String? = "",
                    @SerializedName("width")
                    val width: Int? = 0
                )
    
                data class Medium(
                    @SerializedName("ext")
                    val ext: String? = "",
                    @SerializedName("hash")
                    val hash: String? = "",
                    @SerializedName("height")
                    val height: Int? = 0,
                    @SerializedName("mime")
                    val mime: String? = "",
                    @SerializedName("name")
                    val name: String? = "",
                    @SerializedName("path")
                    val path: Any? = Any(),
                    @SerializedName("size")
                    val size: Double? = 0.0,
                    @SerializedName("url")
                    val url: String? = "",
                    @SerializedName("width")
                    val width: Int? = 0
                )
    
                data class Small(
                    @SerializedName("ext")
                    val ext: String? = "",
                    @SerializedName("hash")
                    val hash: String? = "",
                    @SerializedName("height")
                    val height: Int? = 0,
                    @SerializedName("mime")
                    val mime: String? = "",
                    @SerializedName("name")
                    val name: String? = "",
                    @SerializedName("path")
                    val path: Any? = Any(),
                    @SerializedName("size")
                    val size: Double? = 0.0,
                    @SerializedName("url")
                    val url: String? = "",
                    @SerializedName("width")
                    val width: Int? = 0
                )
    
                data class Thumbnail(
                    @SerializedName("ext")
                    val ext: String? = "",
                    @SerializedName("hash")
                    val hash: String? = "",
                    @SerializedName("height")
                    val height: Int? = 0,
                    @SerializedName("mime")
                    val mime: String? = "",
                    @SerializedName("name")
                    val name: String? = "",
                    @SerializedName("path")
                    val path: Any? = Any(),
                    @SerializedName("size")
                    val size: Double? = 0.0,
                    @SerializedName("url")
                    val url: String? = "",
                    @SerializedName("width")
                    val width: Int? = 0
                )
            }
        }
    }
}