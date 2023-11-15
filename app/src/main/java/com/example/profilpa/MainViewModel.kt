package com.example.profilpa

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainViewModel : ViewModel() {
    val movies = MutableStateFlow<List<TmdbMovie>>(listOf())
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build();

    val api = retrofit.create(Api::class.java)
    // à partir de là, on peut appeler api.lastMovies(...)

    fun getMovies() {
        viewModelScope.launch {
            movies.value = api.lastmovies("73fbeeb046f41168a80509da0ee03c8c").results
        }
    }
}