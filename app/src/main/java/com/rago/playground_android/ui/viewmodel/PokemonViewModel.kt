package com.rago.playground_android.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.rago.playground_android.data.model.Result
import com.rago.playground_android.domain.usecases.PokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val pokemonUseCase: PokemonUseCase
) : ViewModel() {
    private val _pokemonState: MutableStateFlow<PagingData<Result>> =
        MutableStateFlow(value = PagingData.empty())
    val pokemonState: MutableStateFlow<PagingData<Result>> get() = _pokemonState

    init {
        viewModelScope.launch {
            getPokemon()
        }
    }
    private suspend fun getPokemon() {
        viewModelScope.launch {
            pokemonUseCase.executeGetAllPokemon(0)
                .distinctUntilChanged()
                .cachedIn(viewModelScope)
                .collect {
                    _pokemonState.value = it
                }
        }
    }

}