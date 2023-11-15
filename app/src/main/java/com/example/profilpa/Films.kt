package com.example.profilpa

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun Film(viewModel: MainViewModel){
    // Observation dans un composant compose, transforme le MutableStateFlow en une liste
    val movies by viewModel.movies.collectAsStateWithLifecycle()

    // Pour n'appeler viewModel.getMovies() qu'une seule fois = première apparition du composant Films
    LaunchedEffect(key1 = true) { viewModel.getMovies() }

    LazyVerticalGrid(columns = GridCells.Fixed(1)) {
        for(movie in movies){
            val imageurl = "https://image.tmdb.org/t/p/w780/" + movie.poster_path
        items(1){
            Text(text = movie.original_title)

        }
        }
    }
}