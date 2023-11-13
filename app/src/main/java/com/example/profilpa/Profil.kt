package com.example.profilpa

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Profile(windowClass: WindowSizeClass,onClick: () -> Unit ) {
    when (windowClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                PDP()
                Titre()
                SousTitre()
                Liens()
                FilledButtonExample(onClick)

            }
        }
        else -> {
            Row(Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically) {
                Column() {
                    PDP()
                }
                Spacer(Modifier.width(100.dp))
                Column() {
                    Titre()
                    SousTitre()
                    Liens()
                    FilledButtonExample( onClick)
                }

            }
        }
    }
}



@Composable
fun PDP(){
    Column() {
        Image(
            painterResource(id = R.drawable.pdp),
            contentDescription = "PDP Chat cute",
            Modifier
                .clip(CircleShape)
                .size(300.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun Titre(){
    Text(
        text ="Calia Coulibaly",
        fontWeight = FontWeight.Medium,
        fontSize = 35.sp
    )
    Spacer(Modifier.height(30.dp))

}

@Composable
fun SousTitre(){
    Text(
        text = "Étudiante en 3ème année du BUT MMI",
        fontSize = 15.sp)
    Spacer(Modifier.height(5.dp))
    Text(
        text = "IUT Paul Sabatier 3 - Castres",
        fontSize = 15.sp
    )
    Spacer(Modifier.height(20.dp))

}

@Composable
fun Liens(){
    Column() {
        Row() {
            Image(
                painterResource(id = R.drawable.mail),
                contentDescription = "logo_mail",
                Modifier.size(25.dp)
            )
            Text(
                text = "calia.coulibaly@gmail.com",
                fontSize = 13.sp
            )
        }

        Row() {
            Image(
                painterResource(id = R.drawable.ink),
                contentDescription = "logo_linkdin",
                Modifier.size(45.dp)
            )
            Text(
                text = "www.linkedin.com/in/calia-coulibaly/",
                fontSize = 13.sp
            )

        }
    }
}

@Composable
fun FilledButtonExample(onClick: () -> Unit) {
    Spacer(Modifier.height(50.dp))
    Button(onClick =  onClick) {
        Text("Lancez")
    }
}




