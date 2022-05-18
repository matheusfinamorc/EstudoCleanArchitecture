package com.example.projetoestudo1.feature.presentation.fragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetoestudo1.architecture.Resource
import com.example.projetoestudo1.feature.domain.model.games.GamesResponse
import com.example.projetoestudo1.feature.domain.usecase.GamesUseCase
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class GamesViewModel(private val useCase: GamesUseCase) : ViewModel() {
    private val _getGameList: MutableLiveData<GamesResponse> = MutableLiveData()
    val getGameList = _getGameList as LiveData<GamesResponse>

    fun getListGames() = viewModelScope.launch {

        useCase.getListGames().onEach {
            when (it) {
                is Resource.Success -> {
                    _getGameList.postValue(it.data!![0])
                }
            }
        }
    }
}