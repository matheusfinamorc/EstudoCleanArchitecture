package com.example.projetoestudo1.feature.data.repository

import android.util.Log
import com.example.projetoestudo1.architecture.Resource
import com.example.projetoestudo1.feature.domain.datasource.GamesDataSource
import com.example.projetoestudo1.feature.domain.model.games.GamesResponse
import com.example.projetoestudo1.feature.domain.repository.GamesRepository
import kotlinx.coroutines.flow.*
import retrofit2.HttpException
import java.io.IOException

class GamesRepositoryImpl(private val dataSource: GamesDataSource) : GamesRepository {
    override suspend fun getListGames(): Flow<Resource<List<GamesResponse>>> {
        return dataSource.getListGames().catch {
            when (it) {
                is HttpException -> {
                    val code = it.code().toString()
                    val message = it.message()
                    emit(Resource.Error(data = null, code = code, messagem = message))

                    Log.i("Response", "DataSource Error: ${it.code()}")
                }
                is IOException -> {
                    emit(Resource.Failure(data = null, throwable = it))
                    Log.i("Response", "DataSource Failure: ${it}")
                }
                else -> {
                    emit(Resource.Failure(data = null, throwable = it))
                }
            }
        }
    }
}
