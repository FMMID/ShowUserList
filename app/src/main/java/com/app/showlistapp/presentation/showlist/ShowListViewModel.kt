package com.app.showlistapp.presentation.showlist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.showlistapp.domain.entities.USPublicEntity
import com.app.showlistapp.domain.usecase.GetUSPublicUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ShowListViewModel(
    private val getUSPublicUseCase: GetUSPublicUseCase
) : ViewModel() {

    private val showListDataMutableStateFlow = MutableStateFlow(listOf<USPublicEntity>())
    val showListDataStateFlow = showListDataMutableStateFlow.asStateFlow()

    private val showFailureStateMutableStateFlow = MutableStateFlow("")
    val showFailureStateStateFlow = showFailureStateMutableStateFlow.asStateFlow()


    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        Log.d(TAG, "coroutine exception: $exception")
    }

    fun fetchListData() {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            getUSPublicUseCase(Unit)
                .onSuccess { usPublicEntities ->
                    showListDataMutableStateFlow.tryEmit(usPublicEntities)
                }
                .onFailure { error ->
                    showFailureStateMutableStateFlow.tryEmit(error.toString())
                }
        }
    }

    companion object {
        private const val TAG = "ShowListViewModel"
    }
}