package com.example.projetoestudo1.feature.data.remote.service

import com.example.projetoestudo1.feature.domain.model.games.GamesResponse
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("api/games")
    suspend fun getListGames(): Response<List<GamesResponse>>
}