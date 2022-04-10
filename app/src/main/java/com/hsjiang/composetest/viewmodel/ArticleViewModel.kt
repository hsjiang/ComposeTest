package com.hsjiang.composetest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hsjiang.composetest.data.model.Article
import com.hsjiang.composetest.domain.article.HotArticleListUseCase
import com.hsjiang.library.result.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(
    private val articleListUseCase: HotArticleListUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<Result<List<Article>?>>(Result.Loading)

    val uiState: StateFlow<Result<List<Article>?>>
        get() = _uiState

    fun loadArticles() {
        viewModelScope.launch {
            val map = hashMapOf<String, Any>().apply {
                put("cityId", 101)
                put("page", 1)
                put("limit", 10)
            }
            _uiState.value = Result.Loading
            articleListUseCase(map).catch {
                it.printStackTrace()
            }.collect {
                _uiState.value = it
            }
        }
    }

}