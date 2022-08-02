package com.example.app.samples

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET

interface API {
    @GET("lessons")
    fun lessons(): Call<Any>
}

val RETROFIT: Retrofit = Retrofit.Builder().baseUrl("https://api.hencoder.com/").build()

fun <T> create(clazz: Class<T>): T {
    return RETROFIT.create(clazz)
}

// inline+reified可以获得泛型的类型
inline fun <reified T> createInLine(): T {
    return RETROFIT.create(T::class.java)
}

fun main() {
    println(create(API::class.java))

    println(createInLine<API>())
}