package com.example.watchmodeapp.ui.home

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
class HomeViewModel @Inject constructor(
    private val repository: WatchmodeRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState

    private val compositeDisposable = CompositeDisposable()

    init {
        fetchMoviesAndTvShows()
    }

    private fun fetchMoviesAndTvShows() {
        _uiState.value = HomeUiState.Loading

        val disposable = repository.getMoviesAndTvShows()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    _uiState.value = HomeUiState.Success(
                        movies = result.first,
                        tvShows = result.second
                    )
                },
                { error ->
                    _uiState.value = HomeUiState.Error(
                        message = error.localizedMessage ?: "Something went wrong"
                    )
                }
            )

        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}