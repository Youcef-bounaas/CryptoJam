package com.youcef_bounaas.cryptojam.presentation.coin_detail

import com.youcef_bounaas.cryptojam.domain.model.Coin
import com.youcef_bounaas.cryptojam.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
