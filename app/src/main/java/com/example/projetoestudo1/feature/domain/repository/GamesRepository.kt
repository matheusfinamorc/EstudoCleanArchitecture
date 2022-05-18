package com.example.projetoestudo1.feature.domain.repository

import com.example.projetoestudo1.architecture.Resource
import com.example.projetoestudo1.feature.domain.model.games.GamesResponse
import kotlinx.coroutines.flow.Flow

interface GamesRepository {
    suspend fun getListGames(): Flow<Resource<List<GamesResponse>>>
}