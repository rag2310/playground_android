package com.rago.playground_android.data.utils

sealed class GenericResponse<out T> {
    data object Loading : GenericResponse<Nothing>()

    data class Success<out T>(
        val data: T
    ) : GenericResponse<T>()

    data class Failure(
        val e: Exception
    ) : GenericResponse<Nothing>()

}