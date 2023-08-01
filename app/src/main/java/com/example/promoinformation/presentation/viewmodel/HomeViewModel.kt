package com.example.promoinformation.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.core.dispatcher.DispatcherProvider
import com.example.core.model.usecase.GetPromosUseCase
import kotlinx.coroutines.withContext
import javax.inject.Inject

import com.example.core.abstraction.BaseViewModel
import com.example.core.model.model.Promo
import com.example.core.util.exception.Failure
import com.example.core.util.extension.onError
import com.example.core.util.extension.onSuccess
import com.example.core.abstraction.UseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel @Inject constructor(
    private val dispatcherProvider: DispatcherProvider,
    private val getPromosUseCase: GetPromosUseCase
) : BaseViewModel<HomeViewModel.MainUiState>() {

    sealed class MainUiState {
        object Loading : MainUiState()
        data class Success(val data: List<Promo>) : MainUiState()
        data class Failed(val failure: Failure) : MainUiState()
    }

    fun getPromos() {
        viewModelScope.launch(dispatcherProvider.io) {
            getPromosUseCase.run(UseCase.None)
                .onSuccess {
                    withContext(dispatcherProvider.main) {
                        _uiState.value = MainUiState.Success(it)
                    }
                }
                .onError {
                    withContext(dispatcherProvider.main) {
                        _uiState.value = MainUiState.Failed(it)
                    }
                }
        }
    }

    override val initialUiState: MainUiState
        get() = MainUiState.Loading

}