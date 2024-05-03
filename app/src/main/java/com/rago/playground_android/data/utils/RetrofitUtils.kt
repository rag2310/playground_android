package com.rago.playground_android.data.utils

import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

fun <T> retrofitCallbackFlow(api: Call<T>): Flow<GenericResponse<T>> = callbackFlow {
    val callback: Callback<T> = object : Callback<T> {
        override fun onResponse(call: Call<T>, response: Response<T>) {

            if (response.errorBody() != null) {
                val json = response.errorBody()?.string() ?: ""
                trySend(GenericResponse.Failure(e = Exception(json)))
            }

            if (response.body() != null) {
                trySend(GenericResponse.Success<T>(data = response.body()!!))
            } else {
                trySend(GenericResponse.Failure(e = Exception("Response Body is null and haven't response ErrorBoy")))
            }
        }

        override fun onFailure(call: Call<T>, t: Throwable) {
            trySend(GenericResponse.Failure(Exception(t.message)))
        }
    }

    api.enqueue(callback)


    awaitClose {
        if (api.isCanceled) {
            api.cancel()
        }
    }
}
