package com.steve_md.crypto_app.data.remote.api

import com.steve_md.crypto_app.data.remote.dto.CoinDetailDto
import com.steve_md.crypto_app.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApiService {
    @GET("/v1/coins")
    suspend fun getCoins() : List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(
        @Path("coinId`") coinId: String
    ) : CoinDetailDto
}