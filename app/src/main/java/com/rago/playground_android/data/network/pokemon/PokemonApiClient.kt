package com.rago.playground_android.data.network.pokemon

import com.rago.playground_android.data.model.PokemonAll
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApiClient {
    @GET("pokemon/")
    fun getAllPokemon(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int = 10
    ): Call<PokemonAll>
}