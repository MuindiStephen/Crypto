package com.steve_md.crypto_app.presentation.fragments.main.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.steve_md.crypto_app.common.Resource
import com.steve_md.crypto_app.domain.model.Coin
import com.steve_md.crypto_app.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

// Purpose is to maintain now the State of the App eg. UI screen rotation, progress Bar config...
@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _state = MutableLiveData<Resource<List<Coin>>>()
    val state:LiveData<Resource<List<Coin>>>
    get() = _state


    @SuppressLint("NullSafeMutableLiveData")
    private fun getCoins() {
        // Invoked by UseCase
        getCoinsUseCase().onEach {
            when(it) {
                is Resource.Success -> {
                    _state.value = (it.data?: emptyList() ) as Resource<List<Coin>>
                }
                is Resource.Loading -> {
                    _state.value = null
                }
                is Resource.Error -> {
                    _state.value = ((it.message?: "An unexpected error occurred") as Resource<List<Coin>>?)
                }
            }
        }
    }

}
