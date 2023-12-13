package com.example.profilpa

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainViewModel : ViewModel() {
    val movies = MutableStateFlow<List<TmdbMovie>>(listOf())
    val series = MutableStateFlow<List<TmdbTv>>(listOf())
    val actors = MutableStateFlow<List<TmdbActor>>(listOf())
    val movie = MutableStateFlow<TmdbMovieDetail>(TmdbMovieDetail())
    val serie = MutableStateFlow<TmdbTvDetail>(TmdbTvDetail())
    val acteur = MutableStateFlow<TmdbPersonDetail>(TmdbPersonDetail())


    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build();

    val api = retrofit.create(Api::class.java)

    fun getMovies() {
        viewModelScope.launch {
            movies.value = api.lastmovies("73fbeeb046f41168a80509da0ee03c8c").results
        }
    }
    fun getSeries() {
        viewModelScope.launch {
            series.value = api.lasttv("73fbeeb046f41168a80509da0ee03c8c").results
        }
    }
    fun getActor() {
        viewModelScope.launch {
            actors.value = api.lastactor("73fbeeb046f41168a80509da0ee03c8c").results
        }
    }
    fun getMovie(id:String) {
        viewModelScope.launch {
            movie.value = api.movie(id, "73fbeeb046f41168a80509da0ee03c8c")
        }
    }

    fun getSerie(id: String){
        viewModelScope.launch {
            serie.value = api.serie(id, "73fbeeb046f41168a80509da0ee03c8c")
        }
    }

    fun getActeur(id: String){
        viewModelScope.launch {
            acteur.value = api.actor(id, "73fbeeb046f41168a80509da0ee03c8c")
        }
    }
}