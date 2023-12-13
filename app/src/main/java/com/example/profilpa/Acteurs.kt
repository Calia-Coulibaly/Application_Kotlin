package com.example.profilpa

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
public fun Acteurs(viewModel: MainViewModel, navController: NavHostController) {
    // Observation dans un composant compose, transforme le MutableStateFlow en une liste
    val actors by viewModel.actors.collectAsStateWithLifecycle()

    // Pour n'appeler viewModel.getMovies() qu'une seule fois = première apparition du composant Films
    LaunchedEffect(key1 = true) { viewModel.getActor() }

    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        for (actor in actors) {
            val imageurl = "https://image.tmdb.org/t/p/w780/" + actor.profile_path
            items(1) {
                Card(
                    onClick = {navController.navigate("person/${actor.id}")},
                    border = BorderStroke(1.dp, Color.LightGray),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    modifier = Modifier
                        .width(width = 300.dp)
                        .padding(5.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(2.dp)
                    ) {
                        // AsyncImage va afficher l'image ici
                        AsyncImage(
                            model = imageurl,
                            contentDescription = "Image du film ${actor.original_name}",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(220.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                        )
                        Text(
                            text = actor.original_name,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                        )
                        Spacer(Modifier.height(10.dp))
                    }
                }
            }
        }
    }
}
