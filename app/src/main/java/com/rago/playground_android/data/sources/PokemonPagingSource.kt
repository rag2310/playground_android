package com.rago.playground_android.data.sources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.rago.playground_android.data.model.Result
import com.rago.playground_android.data.network.pokemon.PokemonApiClient
import com.rago.playground_android.data.utils.GenericResponse
import com.rago.playground_android.data.utils.retrofitCallbackFlow
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class PokemonPagingSource @Inject constructor(
    private val pokemonApiClient: PokemonApiClient
) : PagingSource<Int, Result>() {
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        try {
            val currentPage = params.key ?: 0
            val response = retrofitCallbackFlow(
                pokemonApiClient.getAllPokemon(currentPage)
            ).firstOrNull()

            return when (response) {
                is GenericResponse.Failure -> {
                    LoadResult.Error(Exception("response is ${response.e}"))
                }

                GenericResponse.Loading -> {
                    LoadResult.Invalid()
                }

                is GenericResponse.Success -> {
                    LoadResult.Page(
                        data = response.data.results,
                        prevKey = if (currentPage == 0) null else currentPage - 1,
                        nextKey = if (response.data.results.isEmpty()) null else currentPage + 10
                    )
                }

                null -> {
                    return LoadResult.Error(Exception("response is null"))
                }
            }
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }
}