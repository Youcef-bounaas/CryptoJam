package com.youcef_bounaas.cryptojam.presentation.coin_list

import com.youcef_bounaas.cryptojam.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
