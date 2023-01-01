package com.steve_md.crypto_app.domain.use_case.get_coin

import com.steve_md.crypto_app.common.Resource
import com.steve_md.crypto_app.data.remote.dto.toCoin
import com.steve_md.crypto_app.data.remote.dto.toCoinDetail
import com.steve_md.crypto_app.domain.model.Coin
import com.steve_md.crypto_app.domain.model.CoinDetail
import com.steve_md.crypto_app.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


// Business Logic
class GetCoinUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
     operator fun invoke(coinId : String) : Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coins = coinRepository.getCoinById(coinId).toCoinDetail()
            Resource.Success(coins)
        } catch (e:HttpException) {
            emit(Resource.Error(e.localizedMessage?: "An unexpected error has occurred!"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Please your internet connection"))
        }
    }
}