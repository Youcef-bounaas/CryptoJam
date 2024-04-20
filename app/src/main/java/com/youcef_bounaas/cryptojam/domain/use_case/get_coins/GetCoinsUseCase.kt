package com.youcef_bounaas.cryptojam.domain.use_case.get_coins

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.youcef_bounaas.cryptojam.common.Resource
import com.youcef_bounaas.cryptojam.data.remote.dto.toCoin
import com.youcef_bounaas.cryptojam.domain.model.Coin
import com.youcef_bounaas.cryptojam.domain.repository.CoinRepository
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow




class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
){
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch(e: HttpException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Coin>>("Couldn't reach server. Check your internet connection"))
        }

    }
}