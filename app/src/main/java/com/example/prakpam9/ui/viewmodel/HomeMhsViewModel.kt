package com.example.prakpam9.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prakpam9.Data.Entity.Mahasiswa
import com.example.prakpam9.Repository.RepositoryMhs
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

class HomeMhsViewModel(
    private val repositoryMhs: RepositoryMhs
) : ViewModel() {

    val homeUIState: StateFlow<HomeUiState> = repositoryMhs.getAllMhs()
        .filterNotNull()
        .map { list ->
            HomeUiState(
                listMhs = list.toList(),
                isLoading = false
            )
        }
        .onStart {
            emit(HomeUiState(isLoading = true))
            delay(900)
        }
        .catch { throwable ->
            emit(
                HomeUiState(
                    isLoading = false,
                    isError = true,
                    errorMessage = throwable.message ?: "Terjadi Kesalahan"
                )
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(500),
            initialValue = HomeUiState(
                isLoading = true
            )
        )
}

data class HomeUiState(
    val listMhs: List<Mahasiswa> = listOf(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
)
