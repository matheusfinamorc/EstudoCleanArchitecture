package com.example.projetoestudo1.feature.domain.usecase

import com.example.projetoestudo1.architecture.Resource
import com.example.projetoestudo1.feature.domain.model.games.GamesResponse
import com.example.projetoestudo1.feature.domain.repository.GamesRepository
import kotlinx.coroutines.flow.Flow

interface GetGamesUseCase {
    suspend operator fun invoke(): Flow<Resource<List<GamesResponse>>>
}

class GetGamesUseCaseImpl(private val repository: GamesRepository): GetGamesUseCase {
    override suspend fun invoke(): Flow<Resource<List<GamesResponse>>> {
        return repository.getListGames()
    }
}