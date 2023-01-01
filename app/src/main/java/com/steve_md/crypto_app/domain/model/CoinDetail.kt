package com.steve_md.crypto_app.domain.model

import com.steve_md.crypto_app.data.remote.dto.Team

data class CoinDetail(
    val coinId : String,
    val name : String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: Team
)
