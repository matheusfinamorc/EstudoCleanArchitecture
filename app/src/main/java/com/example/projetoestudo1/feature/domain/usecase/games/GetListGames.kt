package com.example.projetoestudo1.feature.domain.usecase.games

import android.util.Log
import com.example.projetoestudo1.architecture.Resource
import com.example.projetoestudo1.feature.domain.model.games.GamesResponse
import com.example.projetoestudo1.feature.domain.repository.GamesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import retrofit2.HttpException
import java.io.IOException

class GetListGames(private val repository: GamesRepository) {

    suspend operator fun invoke(): Flow<Resource<List<GamesResponse>>>{
        return repository.getListGames()
//        return repository.getListGames().catch {
//            when (it){
//                is HttpException -> {
//                    emit(Resource.Error(code = it.code().toString(), messagem = it.message()))
//                    Log.i("Response", "invoke: HttpException: ${it.code()}")
//                }
//                is IOException -> {
//                    emit(Resource.Failure(throwable = it))
//                    Log.i("Response", "invoke: IOException: ${it}")
//
//                }
//                else ->
//                    emit(Resource.Exception(throwable = it))
//            }
//        }
    }

}
