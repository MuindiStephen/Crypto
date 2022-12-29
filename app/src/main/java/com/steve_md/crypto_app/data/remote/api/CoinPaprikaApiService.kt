package com.steve_md.crypto_app.data.remote.api

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApiService {
    @GET("/v1/coins")
    suspend fun getCoins() : ResponseBody

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(
        @Path("coinId`") coinId: String
    ) : ResponseBody
}