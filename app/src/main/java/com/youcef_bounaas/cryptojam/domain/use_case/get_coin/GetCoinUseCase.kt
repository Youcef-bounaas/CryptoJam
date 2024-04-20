package com.youcef_bounaas.cryptojam.domain.use_case.get_coin

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.youcef_bounaas.cryptojam.common.Resource
import com.youcef_bounaas.cryptojam.data.remote.dto.toCoin
import com.youcef_bounaas.cryptojam.data.remote.dto.toCoinDetail
import com.youcef_bounaas.cryptojam.domain.model.Coin
import com.youcef_bounaas.cryptojam.domain.model.CoinDetail
import com.youcef_bounaas.cryptojam.domain.repository.CoinRepository
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow




class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
){
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch(e: HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch(e: IOException) {
            emit(Resource.Error<CoinDetail>("Couldn't reach server. Check your internet connection"))
        }

    }
}