package com.hsjiang.composetest.data.source

import com.hsjiang.composetest.data.model.Article
import com.hsjiang.library.result.Result

interface ArticleDatasource {

    suspend fun getHotArticleList(params: Map<String, Any>): Result<List<Article>?>
}