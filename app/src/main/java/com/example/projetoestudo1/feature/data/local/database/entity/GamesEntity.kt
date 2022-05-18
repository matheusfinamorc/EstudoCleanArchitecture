package com.example.projetoestudo1.feature.data.local.database.entity

import com.example.projetoestudo1.feature.domain.model.games.GamesResponse

data class GamesEntity(
    val title: String = ""
){
    fun toGames(): GamesResponse {
        return GamesResponse(
            title = title
        )
    }
}
