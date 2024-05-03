package com.rago.playground_android.di

import com.rago.playground_android.data.network.pokemon.PokemonApiClient
import com.rago.playground_android.data.repositories.PokemonRepository
import com.rago.playground_android.data.repositories.PokemonRepositoryImpl
import com.rago.playground_android.data.sources.PokemonPagingSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providePokemonRepository(
        pokemonApiClient: PokemonApiClient
    ): PokemonRepository {
        return PokemonRepositoryImpl(
            pokemonApiClient,
            pokemonPagingSource = PokemonPagingSource(pokemonApiClient)
        )
    }
}