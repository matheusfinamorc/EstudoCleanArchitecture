package com.example.projetoestudo1.feature.di

import com.example.projetoestudo1.feature.domain.usecase.GamesUseCase
import com.example.projetoestudo1.feature.domain.usecase.games.GetListGames
import org.koin.dsl.module

object UseCaseModule {
    val get = module(override = true){
        single {
            GamesUseCase(
                getListGames = GetListGames(
                    repository = get()
                )
            )
        }
    }
}