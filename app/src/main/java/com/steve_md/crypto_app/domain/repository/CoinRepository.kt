package com.steve_md.crypto_app.domain.repository

import com.steve_md.crypto_app.common.Resource
import com.steve_md.crypto_app.data.remote.dto.CoinDetailDto
import com.steve_md.crypto_app.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins() : List<CoinDto>
    suspend fun getCoinById(coinId: String) : CoinDetailDto
}