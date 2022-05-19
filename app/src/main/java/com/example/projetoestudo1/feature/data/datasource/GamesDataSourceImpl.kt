package com.example.projetoestudo1.feature.data.datasource

import com.example.projetoestudo1.architecture.Resource
import com.example.projetoestudo1.feature.data.remote.service.Api
import com.example.projetoestudo1.feature.domain.datasource.GamesDataSource
import com.example.projetoestudo1.feature.domain.model.games.GamesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GamesDataSourceImpl(private val api: Api) : GamesDataSource {

    override suspend fun getListGames(): Flow<Resource<List<GamesResponse>>> = flow {
        val response = api.getListGames()

        when(response.code()){
            in 200..300 -> {
                val result = response.body()!!
                emit(Resource.Success(result))

            }
            else -> {
                val code = response.code().toString()
                val message = response.message()
                emit(Resource.Error(data = null,code,message))
            }
        }
    }.flowOn(Dispatchers.IO)

}