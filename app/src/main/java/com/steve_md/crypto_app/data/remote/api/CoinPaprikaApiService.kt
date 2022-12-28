package com.steve_md.crypto_app.data.remote.api

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinPaprikaApiService {
    @GET
    suspend fun getCoins() : ResponseBody

    @GET
    suspend fun getC(
        @Query("") list: String
    ) : ResponseBody
}