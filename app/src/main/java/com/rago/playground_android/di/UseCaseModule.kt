package com.rago.playground_android.di

import com.rago.playground_android.data.repositories.PokemonRepository
import com.rago.playground_android.domain.usecases.PokemonUseCase
import com.rago.playground_android.domain.usecases.PokemonUserCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.android.scopes.ViewScoped


@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @ViewModelScoped
    @Provides
    fun providePokemonUseCase(
        pokemonRepository: PokemonRepository
    ) : PokemonUseCase {
        return PokemonUserCaseImpl(pokemonRepository)
    }
}