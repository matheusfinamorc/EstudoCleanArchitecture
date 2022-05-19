package com.example.projetoestudo1.feature.presentation.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetoestudo1.architecture.Resource
import com.example.projetoestudo1.feature.domain.model.games.GamesResponse
import com.example.projetoestudo1.feature.domain.repository.GamesRepository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class GamesViewModel(
    private val repository: GamesRepository,
) : ViewModel() {
    private val _getGameList: MutableLiveData<List<GamesResponse>> = MutableLiveData()
    val getGameList = _getGameList as LiveData<List<GamesResponse>>

    fun getListGames() = viewModelScope.launch {
        repository.getListGames().collectLatest {
            when(it){
                is Resource.Success -> {
                    _getGameList.postValue(it.data!!)
                }
                is Resource.Error -> println("---------- error")
                is Resource.Exception -> println("---------- exception")
                is Resource.Failure -> println("---------- failure")
            }
        }
    }
}