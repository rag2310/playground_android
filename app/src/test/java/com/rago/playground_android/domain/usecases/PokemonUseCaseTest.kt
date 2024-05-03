package com.rago.playground_android.domain.usecases

import com.google.gson.Gson
import com.rago.playground_android.data.model.PokemonAll
import com.rago.playground_android.data.repositories.PokemonRepository
import com.rago.playground_android.data.utils.GenericResponse
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

val jsonString = """
        {
            "count": 1302,
            "next": "https://pokeapi.co/api/v2/pokemon/?offset=10&limit=10",
            "previous": null,
            "results": [
                {
                    "name": "bulbasaur",
                    "url": "https://pokeapi.co/api/v2/pokemon/1/"
                },
                {
                    "name": "ivysaur",
                    "url": "https://pokeapi.co/api/v2/pokemon/2/"
                },
                {
                    "name": "venusaur",
                    "url": "https://pokeapi.co/api/v2/pokemon/3/"
                },
                {
                    "name": "charmander",
                    "url": "https://pokeapi.co/api/v2/pokemon/4/"
                },
                {
                    "name": "charmeleon",
                    "url": "https://pokeapi.co/api/v2/pokemon/5/"
                },
                {
                    "name": "charizard",
                    "url": "https://pokeapi.co/api/v2/pokemon/6/"
                },
                {
                    "name": "squirtle",
                    "url": "https://pokeapi.co/api/v2/pokemon/7/"
                },
                {
                    "name": "wartortle",
                    "url": "https://pokeapi.co/api/v2/pokemon/8/"
                },
                {
                    "name": "blastoise",
                    "url": "https://pokeapi.co/api/v2/pokemon/9/"
                },
                {
                    "name": "caterpie",
                    "url": "https://pokeapi.co/api/v2/pokemon/10/"
                }
            ]
        }
    """.trimIndent()

class PokemonUseCaseTest {
    /*@RelaxedMockK
    private lateinit var pokemonRepository: PokemonRepository

    private lateinit var getAllPokemonUseCase: PokemonUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getAllPokemonUseCase = PokemonUseCase(pokemonRepository)
    }*/
}