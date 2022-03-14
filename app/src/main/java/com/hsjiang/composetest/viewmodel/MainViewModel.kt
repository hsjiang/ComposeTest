package com.hsjiang.composetest.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.hsjiang.composetest.data.repository.ArticleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application,
    private val repository: ArticleRepository
) :
    AndroidViewModel(application) {

    val sharedInFlow: SharedFlow<Int> = flow<Int> {
        var currentValue = 0
        while (currentValue < 20) {
            delay(300)
            currentValue++
            emit(currentValue)
            Log.d("flowTest", "currentValue : $currentValue")
        }
    }.flowOn(Dispatchers.IO).shareIn(viewModelScope, WhileSubscribed(5000))

//    val stateInFlow:StateFlow<Int> = flow<Int> {
//
//    }.stateIn(viewModelScope)


    fun loadList() {
        viewModelScope.launch {

//            Log.d("articleList", "data: ${gson}")
        }
    }

}