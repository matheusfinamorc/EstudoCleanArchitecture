package com.example.projetoestudo1.feature.domain.datasource

import com.example.projetoestudo1.architecture.Resource
import com.example.projetoestudo1.feature.domain.model.games.GamesResponse
import kotlinx.coroutines.flow.Flow

interface GamesDataSource {
    suspend fun getListGames(): Flow<Resource<List<GamesResponse>>>
}
