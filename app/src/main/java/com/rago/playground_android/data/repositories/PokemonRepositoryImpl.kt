package com.rago.playground_android.data.repositories


import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.rago.playground_android.data.model.Result
import com.rago.playground_android.data.network.pokemon.PokemonApiClient
import com.rago.playground_android.data.sources.PokemonPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val pokemonApiClient: PokemonApiClient,
    private val pokemonPagingSource: PokemonPagingSource
) :
    PokemonRepository {
    override fun getAllPokemon(): Flow<PagingData<Result>> {

        return Pager(
            config = PagingConfig(pageSize = 100, prefetchDistance = 2),
            pagingSourceFactory = {
                pokemonPagingSource
            }
        ).flow
    }
}