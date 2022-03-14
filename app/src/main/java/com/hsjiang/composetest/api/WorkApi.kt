package com.hsjiang.composetest.api

import com.hsjiang.composetest.data.model.Article
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface WorkApi {

    @GET("m/article/list")
    @JvmSuppressWildcards
    suspend fun hotArticleList(@QueryMap params: Map<String, Any>): WorkResponse<List<Article>?>


}