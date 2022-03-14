package com.hsjiang.composetest.api

data class WorkResponse<T>(
    val code: Int,
    var data: T?,
    val msg: String?
)