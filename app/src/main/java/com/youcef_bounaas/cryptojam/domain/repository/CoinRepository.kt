package com.youcef_bounaas.cryptojam.domain.repository

import com.youcef_bounaas.cryptojam.data.remote.dto.CoinDetailDto
import com.youcef_bounaas.cryptojam.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto

}