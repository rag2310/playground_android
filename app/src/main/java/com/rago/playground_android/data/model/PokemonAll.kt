package com.rago.playground_android.data.model


import com.google.gson.annotations.SerializedName

data class PokemonAll(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val results: List<Result>
)