package com.rago.playground_android.domain.usecases


import androidx.paging.PagingData
import com.rago.playground_android.data.model.Result
import com.rago.playground_android.data.repositories.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonUserCaseImpl @Inject constructor(
    private val pokemonRepository: PokemonRepository
) :
    PokemonUseCase {
    override fun executeGetAllPokemon(offset: Int): Flow<PagingData<Result>> {
        return pokemonRepository.getAllPokemon()
    }
}


/*class GetMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) : BaseUseCase<Unit, Flow<PagingData<Movie>>> {
    override suspend fun execute(input: Unit): Flow<PagingData<Movie>> {
        return repository.getMovies()
    }
}*/