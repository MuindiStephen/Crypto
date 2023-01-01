package com.steve_md.crypto_app.domain.use_case.get_coins

import com.steve_md.crypto_app.common.Resource
import com.steve_md.crypto_app.data.remote.dto.toCoin
import com.steve_md.crypto_app.domain.model.Coin
import com.steve_md.crypto_app.domain.repository.CoinRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
     operator fun invoke() : Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = coinRepository.getCoins().map { it.toCoin() }
            Resource.Success(coins)

        } catch (e:HttpException) {
            emit(Resource.Error(e.localizedMessage?: "An unexpected error has occurred!"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Please your internet connection"))
        }
    }
}