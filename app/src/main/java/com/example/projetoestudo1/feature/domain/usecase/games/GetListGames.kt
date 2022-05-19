package com.example.projetoestudo1.feature.domain.usecase.games

import com.example.projetoestudo1.architecture.Resource
import com.example.projetoestudo1.feature.domain.model.games.GamesResponse
import com.example.projetoestudo1.feature.domain.repository.GamesRepository
import kotlinx.coroutines.flow.Flow

class GetListGames(private val repository: GamesRepository) {

    suspend operator fun invoke(): Flow<Resource<List<GamesResponse>>> {
        return repository.getListGames()
    }

}
