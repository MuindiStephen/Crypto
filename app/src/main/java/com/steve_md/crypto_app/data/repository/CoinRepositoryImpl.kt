package com.steve_md.crypto_app.data.repository

import com.steve_md.crypto_app.common.Resource
import com.steve_md.crypto_app.data.remote.api.CoinPaprikaApiService
import com.steve_md.crypto_app.data.remote.dto.CoinDetailDto
import com.steve_md.crypto_app.data.remote.dto.CoinDto
import com.steve_md.crypto_app.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl (
    private val coinPaprikaApiService: CoinPaprikaApiService) : CoinRepository {
    override suspend fun getCoins() : List<CoinDto> {
        return coinPaprikaApiService.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return coinPaprikaApiService.getCoinById(coinId)
    }

}