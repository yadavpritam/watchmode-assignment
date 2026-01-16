package com.example.watchmodeapp.data.repository

import com.example.watchmodeapp.data.remote.Constants
import com.example.watchmodeapp.data.remote.WatchmodeApi
import com.example.watchmodeapp.data.model.dto.TitleDto
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.functions.BiFunction
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WatchmodeRepository @Inject constructor(
    private val api: WatchmodeApi
) {

    //  Movies + TV Shows fetch

    fun getMoviesAndTvShows(): Single<Pair<List<TitleDto>, List<TitleDto>>> {

        val moviesSingle = api.getMovies(Constants.API_KEY)
            .map { it.titles }

        val tvShowsSingle = api.getTvShows(Constants.API_KEY)
            .map { it.titles }

        return Single.zip(
            moviesSingle,
            tvShowsSingle,
            BiFunction { movies, tvShows ->
                Pair(movies, tvShows)
            }
        )
    }

    /**
     * Details screen
     */
    fun getTitleDetails(id: Int) =
        api.getTitleDetails(id, Constants.API_KEY)
}
