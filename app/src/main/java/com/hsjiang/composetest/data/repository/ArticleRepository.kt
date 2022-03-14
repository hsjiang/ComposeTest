package com.hsjiang.composetest.data.repository

import com.hsjiang.composetest.data.model.Article
import com.hsjiang.composetest.data.source.ArticleRemoteDatasource
import com.hsjiang.library.result.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleRepository @Inject constructor(private val remoteDatasource: ArticleRemoteDatasource) {

    fun list(params: Map<String, Any>): Flow<Result<List<Article>?>> {
        return flow {
            emit(remoteDatasource.getHotArticleList(params))
        }
    }
}