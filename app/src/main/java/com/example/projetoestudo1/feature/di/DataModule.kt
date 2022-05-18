package com.example.projetoestudo1.feature.di

import com.example.projetoestudo1.App
import com.example.projetoestudo1.feature.data.remote.ClientRetrofit
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object DataModule {
    val get = module {
        single {
            ClientRetrofit.create(
                context = androidContext()
            )
        }
        single {
            App()
        }
    }
}