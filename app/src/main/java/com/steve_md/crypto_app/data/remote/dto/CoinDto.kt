package com.steve_md.crypto_app.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.steve_md.crypto_app.domain.model.Coin

// Created from the API
// To display the list of coins
data class CoinDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("type")
    val type: String
)
fun CoinDto.toCoin() : Coin  {
    return Coin(
        id = id,
        name = name,
        isActive = isActive,
        rank = rank,
        symbol = symbol
    )
}