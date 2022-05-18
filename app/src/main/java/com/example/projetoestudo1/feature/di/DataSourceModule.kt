package com.example.projetoestudo1.feature.di

import com.example.projetoestudo1.feature.data.datasource.GamesDataSourceImpl
import com.example.projetoestudo1.feature.domain.datasource.GamesDataSource
import org.koin.dsl.module

object DataSourceModule {
    val get = module(override = true){
        single<GamesDataSource> {
            GamesDataSourceImpl(
                api = get()
            )
        }
    }
}