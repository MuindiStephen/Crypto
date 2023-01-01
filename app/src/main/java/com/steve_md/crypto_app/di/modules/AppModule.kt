package com.steve_md.crypto_app.di.modules

import com.steve_md.crypto_app.common.Constants.BASE_URL
import com.steve_md.crypto_app.data.remote.api.CoinPaprikaApiService
import com.steve_md.crypto_app.data.repository.CoinRepositoryImpl
import com.steve_md.crypto_app.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

// Dagger-Hilt for Dependency injection
@Module
@InstallIn(SingletonComponent::class)  // All Modules Lives long as the application does ie. until when the app terminates or closed
object AppModule {

    @Provides
    @Singleton // Ensures only one single instance through the Life time of the app
    fun providePaprikaApi (): CoinPaprikaApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApiService) : CoinRepository {
        return CoinRepositoryImpl(api)
    }

}