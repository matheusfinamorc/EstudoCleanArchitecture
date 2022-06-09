package com.example.projetoestudo1.architecture

sealed class Resource<out T> {

    data class Success<out T>(val data: T?): Resource<T>()

    data class Failure<out T>(val data: T? = null, val throwable: Throwable): Resource<T>()

    data class Error<out T>(val data: T? = null, val code: String, val messagem: String): Resource<T>()

    data class Exception<out T>(val throwable: Throwable) : Resource<T>()

    data class Loading<out T>(val data: T? = null, val isLoading: Boolean): Resource<T>()

}
