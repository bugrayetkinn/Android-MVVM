package com.yetkin.daggerhilt.util


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
sealed class Resource<T>(
    val data: T?,
    val exception: String?,
    val status: Status
) {
    class Loading<T> : Resource<T>(null, null, Status.LOADING)
    class Success<T>(data: T?) : Resource<T>(data, null, Status.SUCCESS)
    class Error<T>(exception: String) : Resource<T>(null, exception, Status.ERROR)
}


enum class Status {
    LOADING,
    SUCCESS,
    ERROR
}