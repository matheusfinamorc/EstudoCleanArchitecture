package com.example.projetoestudo1.feature.di

import com.example.projetoestudo1.feature.domain.usecase.GetGamesUseCase
import com.example.projetoestudo1.feature.domain.usecase.GetGamesUseCaseImpl
import org.koin.dsl.module

object GetUseCaseModule {
    val get = module(override = true){
        single<GetGamesUseCase> {
            GetGamesUseCaseImpl(
               repository = get()
            )
        }
    }
}