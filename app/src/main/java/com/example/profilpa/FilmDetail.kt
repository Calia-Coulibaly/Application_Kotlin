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
import androidx.compose.foundation.lazy.grid.items
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
import coil.compose.AsyncImage
import com.example.profilpa.MainViewModel

@Composable
fun FilmDetail(id: String, viewModel: MainViewModel) {
    val movie by viewModel.movie.collectAsStateWithLifecycle()

    val affiche = "https://image.tmdb.org/t/p/w780/" + movie.poster_path
    val poster = "https://image.tmdb.org/t/p/w780/" + movie.backdrop_path

    LaunchedEffect(key1 = true) { viewModel.getMovie(id) }
    LazyVerticalGrid(columns = GridCells.Fixed(1)) {
        item {
            Column() {
                Text(
                    text = movie.original_title,
                    textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )
                AsyncImage(
                    model = poster,
                    contentDescription = "Poster du film ${movie.original_title}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp)
                        .clip(shape = RoundedCornerShape(10.dp))
                )
                Spacer(Modifier.height(10.dp))
                AsyncImage(
                    model = affiche,
                    contentDescription = "Affiche du film ${movie.original_title}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp)
                        .clip(shape = RoundedCornerShape(10.dp))
                )
            }
        }
        items(movie.genres) { credit ->
                    Text(
                        text = credit.name,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )
        }
        item {
            Column(modifier = Modifier.padding(15.dp)) {
                Text(
                    text = movie.release_date,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )
                Spacer(Modifier.height(15.dp))
                Text(
                    text = "Synopsys",
                    textAlign = TextAlign.Left,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )
                Text(
                    text = movie.overview,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            vertical = 8.dp
                        )
                )
                Spacer(Modifier.height(15.dp))
                Text(
                    text = "Tetes d'affiche",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )
            }
        }

        items(movie.credits.cast) { credit ->
            val affiche = "https://image.tmdb.org/t/p/w780/" + credit.profile_path
            Card(
                border = BorderStroke(1.dp, Color.LightGray),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                modifier = Modifier
                    .width(width = 100.dp)
                    .padding(5.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(2.dp)
                ) {
                    AsyncImage(
                        model = affiche,
                        contentDescription = "Image de l'acteur ${credit.name}",
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(10.dp))
                    )
                    Text(
                        text = credit.name,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )
                    Text(
                        text = credit.character,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )
                }
            }
        }
    }
}

