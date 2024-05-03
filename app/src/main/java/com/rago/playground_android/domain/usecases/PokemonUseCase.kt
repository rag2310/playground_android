package com.rago.playground_android.domain.usecases

import androidx.paging.PagingData
import com.rago.playground_android.data.model.Result
import kotlinx.coroutines.flow.Flow

interface PokemonUseCase {
    fun executeGetAllPokemon(offset: Int): Flow<PagingData<Result>>
}