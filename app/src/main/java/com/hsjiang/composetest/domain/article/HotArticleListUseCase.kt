package com.hsjiang.composetest.domain.article

import com.hsjiang.composetest.data.model.Article
import com.hsjiang.composetest.data.repository.ArticleRepository
import com.hsjiang.library.di.IoDispatcher
import com.hsjiang.library.domain.FlowUseCase
import com.hsjiang.library.result.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HotArticleListUseCase @Inject constructor(
    private val articleRepository: ArticleRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : FlowUseCase<Map<String, Any>, List<Article>?>(ioDispatcher) {

    override fun execute(parameters: Map<String, Any>): Flow<Result<List<Article>?>> {
        return articleRepository.list(parameters)
    }
}