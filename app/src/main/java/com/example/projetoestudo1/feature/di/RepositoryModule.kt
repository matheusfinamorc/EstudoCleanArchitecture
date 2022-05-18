package com.example.projetoestudo1.feature.di

import com.example.projetoestudo1.feature.data.repository.GamesRepositoryImpl
import com.example.projetoestudo1.feature.domain.repository.GamesRepository
import org.koin.dsl.module

object RepositoryModule {
    val get = module(override = true){
        single<GamesRepository> {
            GamesRepositoryImpl(dataSource = get())
        }
    }
}