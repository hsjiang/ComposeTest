package com.hsjiang.composetest.data.source

import android.content.Context
import com.hsjiang.composetest.api.WorkApi
import com.hsjiang.composetest.data.model.Article
import com.hsjiang.library.di.IoDispatcher
import com.hsjiang.library.result.Result
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ArticleRemoteDatasource @Inject constructor(
    private val workApi: WorkApi,
    @ApplicationContext private val context: Context,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : ArticleDatasource {
    override suspend fun getHotArticleList(params: Map<String, Any>): Result<List<Article>?> =
        withContext(ioDispatcher) {
            return@withContext getResult(workApi.hotArticleList(params))
        }
}