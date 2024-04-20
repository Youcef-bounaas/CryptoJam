package com.youcef_bounaas.cryptojam.domain.model

import com.youcef_bounaas.cryptojam.data.remote.dto.TeamMember

data class CoinDetail(
    val coinId : String,
    val name : String,
    val description : String,
    val symbol : String,
    val rank : Int,
    val isActive : Boolean,
    val tags: List<String>,
    val team : List<TeamMember>
)
