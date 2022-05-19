package com.example.projetoestudo1.feature.di

import com.example.projetoestudo1.feature.presentation.fragment.GamesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ViewModelModule {
    val get = module(override = true){
        viewModel {
            GamesViewModel(getGamesUseCase = get())
        }
    }
}