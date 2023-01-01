package com.steve_md.crypto_app.domain.model

// Lighter model classes that will render data into the UI [Presentation Layer]
data class Coin(
    val id : String,
    val name:String,
    val isActive: Boolean,
    val rank : Int,
    val symbol : String
    )