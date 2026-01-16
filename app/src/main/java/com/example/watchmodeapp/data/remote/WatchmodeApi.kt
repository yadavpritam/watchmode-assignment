package com.example.watchmodeapp.data.remote
import com.example.watchmodeapp.data.model.response.ListTitlesResponse
import com.example.watchmodeapp.data.model.dto.NetworkDto
import com.example.watchmodeapp.data.model.dto.SourceDto
import com.example.watchmodeapp.data.model.response.TitleDetailsResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WatchmodeApi {

    // 🎬 Movies
    @GET("list-titles/")
    fun getMovies(
        @Query("apiKey") apiKey: String,
        @Query("types") type: String = "movie"
    ): Single<ListTitlesResponse>

    // 📺 TV Shows
    @GET("list-titles/")
    fun getTvShows(
        @Query("apiKey") apiKey: String,
        @Query("types") type: String = "tv_series"
    ): Single<ListTitlesResponse>

    // 📘 Details
    @GET("title/{id}/details/")
    fun getTitleDetails(
        @Path("id") id: Int,
        @Query("apiKey") apiKey: String
    ): Single<TitleDetailsResponse>

    // (OPTIONAL)
    @GET("sources/")
    fun getSources(
        @Query("apiKey") apiKey: String
    ): Single<List<SourceDto>>

    @GET("networks/")
    fun getNetworks(
        @Query("apiKey") apiKey: String
    ): Single<List<NetworkDto>>
}
