import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
fun ActeurDetail(id:String, viewModel: MainViewModel) {
    val acteur by viewModel.acteur.collectAsStateWithLifecycle()

    val pdp = "https://image.tmdb.org/t/p/w780/" + acteur.profile_path

    LaunchedEffect(key1 = true) { viewModel.getActeur(id) }
    LazyVerticalGrid(columns = GridCells.Fixed(1))  {
        item {
            Column() {
                Text(text = acteur.name,
                    textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp))
                AsyncImage(model = pdp,
                    contentDescription = "Image de l'acteur ${acteur.name}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp)
                        .clip(shape = RoundedCornerShape(10.dp)))
                Spacer(Modifier.height(10.dp))
                Column(modifier = Modifier.padding(15.dp)) {
                    Text(
                        text = acteur.birthday,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )
                    Text(
                        text = acteur.place_of_birth,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )
                    Spacer(Modifier.height(15.dp))
                    Text(
                        text = "Biographie",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )
                    Spacer(Modifier.height(15.dp))
                    Text(
                        text = acteur.biography,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )
                    Spacer(Modifier.height(15.dp))
                    Text(
                        text = "Films et series",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )



                }}}}}
