package com.example.ewalle.data


sealed class ResourceResult<T> {

    data class Success<T>(val result: T) : ResourceResult<T>()

    data class Error<T>(val error: Throwable) : ResourceResult<T>()

}
