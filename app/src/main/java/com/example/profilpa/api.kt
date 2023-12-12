package com.example.profilpa

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface Api {
    @GET("trending/movie/week")
    suspend fun lastmovies(@Query("api_key") api_key: String): TmdbMovieResult

    @GET("trending/tv/week")
    suspend fun lasttv(@Query("api_key") api_key: String): TmdbTvResult

    @GET("trending/person/week")
    suspend fun lastactor(@Query("api_key") api_key: String): TmdbActorResult

    @GET("movie/{id}?append_to_response=credits&language=fr")
    suspend fun movie(@Path("id") id:String, @Query("api_key") api_key: String) : TmdbMovieDetail

    @GET("tv/{id}?append_to_response=credits&language=fr")
    suspend fun serie(@Path("id") id:String, @Query("api_key") api_key: String) : TmdbTvDetail

    @GET("person/{id}?append_to_response=credits&language=fr")
    suspend fun actor(@Path("id") id:String, @Query("api_key") api_key: String) : TmdbPersonDetail




    @GET("movie/{id}?append_to_response=credits&language=fr")
    suspend fun credits(@Path("id") id: String, @Query("api_key") api_key: String): CreditsFilm

    @GET("movie/{id}?append_to_response=credits&language=fr")
    suspend fun genres(@Path("id") id: String, @Query("api_key") api_key: String): GenreFilm

    @GET("movie/{id}?append_to_response=credits&language=fr")
    suspend fun actors(@Path("id") id: String, @Query("api_key") api_key: String): CastFilm


}