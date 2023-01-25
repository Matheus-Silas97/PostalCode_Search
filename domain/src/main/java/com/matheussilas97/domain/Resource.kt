package com.matheussilas97.domain

sealed class Resource<out T>
class Loading<out T> : Resource<T>()
class Success<out T>(val data: T? = null) : Resource<T>()
class Failure<out T> : Resource<T>()