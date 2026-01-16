package com.example.watchmodeapp.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.watchmodeapp.data.repository.WatchmodeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: WatchmodeRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _uiState =
        MutableStateFlow<DetailsUiState>(DetailsUiState.Loading)
    val uiState: StateFlow<DetailsUiState> = _uiState


    private val compositeDisposable = CompositeDisposable()

    private val id: Int = savedStateHandle.get<Int>("id") ?: -1

    init {
        fetchDetails()
    }

    fun fetchDetails() {
        repository.getTitleDetails(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { data ->
                    _uiState.value = DetailsUiState.Success(data)
                },
                { error ->
                    _uiState.value = DetailsUiState.Error(
                        error.localizedMessage ?: "Error"
                    )
                }
            )
            .also { compositeDisposable.add(it) }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}