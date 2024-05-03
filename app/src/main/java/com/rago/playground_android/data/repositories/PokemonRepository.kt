package com.rago.playground_android.data.repositories

import androidx.paging.PagingData
import com.rago.playground_android.data.model.PokemonAll
import com.rago.playground_android.data.model.Result
import com.rago.playground_android.data.utils.GenericResponse
import kotlinx.coroutines.flow.Flow


interface PokemonRepository {
    fun getAllPokemon():  Flow<PagingData<Result>>
}