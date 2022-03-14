package com.hsjiang.composetest.data.source

import com.hsjiang.composetest.api.WorkResponse
import com.hsjiang.library.result.Result
import com.hsjiang.library.result.Result.Error
import com.hsjiang.library.result.Result.Success

fun <T> getResult(response: WorkResponse<T?>): Result<T?> {
    return try {
        if (response.code == 200) {
            Success(response.data)
        } else {
            Error(Exception("${response.msg}"))
        }
    } catch (e: Exception) {
        Error(Exception("网络异常，请检查网络后重试", e))
    }
}

fun <T> getResultResponse(response: WorkResponse<T?>): Result<WorkResponse<T?>> {
    return try {
        if (response.code == 1) {
            Error(Exception("${response.msg}"))
        } else {
            Success(response)
        }
    } catch (e: Exception) {
        Error(Exception("网络异常，请检查网络后重试", e))
    }
}