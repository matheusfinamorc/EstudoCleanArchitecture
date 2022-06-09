package com.example.projetoestudo1.feature.presentation.fragment

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetoestudo1.architecture.Resource
import com.example.projetoestudo1.feature.domain.model.games.GamesResponse
import com.example.projetoestudo1.feature.domain.repository.GamesRepository
import com.example.projetoestudo1.feature.domain.usecase.GetGamesUseCase
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.ext.scope

class GamesViewModel(
    private val getGamesUseCase: GetGamesUseCase
) : ViewModel() {
    private val _getGameList: MutableLiveData<List<GamesResponse>> = MutableLiveData()
    val getGameList = _getGameList as LiveData<List<GamesResponse>>
    val loading = MutableLiveData<Boolean>()

    fun getListGames() = viewModelScope.launch {
        getGamesUseCase.invoke().collectLatest {
            when(it){
                is Resource.Success -> {
                    _getGameList.postValue(it.data!!)
                    Log.i("Response", "getListGames: Success get list games")
                }
                is Resource.Loading -> {
                    loading.postValue(it.isLoading)
                }
                is Resource.Error -> Log.i("Response", "getListGames: Error get list games")
                is Resource.Exception -> Log.i("Response", "getListGames: Exception get list games")
                is Resource.Failure -> Log.i("Response", "getListGames: Failure get list games")
            }
        }
    }
}