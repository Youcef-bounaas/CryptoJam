package com.youcef_bounaas.cryptojam.data.repository

import com.youcef_bounaas.cryptojam.data.remote.CoinPaprikaApi
import com.youcef_bounaas.cryptojam.data.remote.dto.CoinDetailDto
import com.youcef_bounaas.cryptojam.data.remote.dto.CoinDto
import com.youcef_bounaas.cryptojam.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}