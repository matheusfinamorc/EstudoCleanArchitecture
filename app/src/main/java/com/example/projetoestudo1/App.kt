package com.example.projetoestudo1

import android.app.Application
import com.example.projetoestudo1.feature.di.*
import com.example.projetoestudo1.feature.domain.usecase.GetGamesUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin()
    }

    private fun startKoin() {
        startKoin {
            androidLogger()
            androidContext(this@App)
            koin.loadModules(
                listOf(
                    DataModule.get,
                    ViewModelModule.get,
                    RepositoryModule.get,
                    GetUseCaseModule.get,
                    DataSourceModule.get,
                )
            )
        }
    }
}