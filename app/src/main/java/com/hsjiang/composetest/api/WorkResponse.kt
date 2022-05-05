package com.hsjiang.composetest.api

data class WorkResponse<T>(
    val code: Int,
    var data: T?,
    val msg: String?
)

fun <T> WorkResponse<T>.isSuccess() = this.code == 200