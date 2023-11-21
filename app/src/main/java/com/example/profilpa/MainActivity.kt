package com.example.profilpa

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.profilpa.ui.theme.ProfilPATheme

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val windowSizeClass = calculateWindowSizeClass(this)
            ProfilPATheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation(windowSizeClass)
                }

            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation(windowClass: WindowSizeClass) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val destinations =
        listOf(Destination.Profile, Destination.Films, Destination.Series, Destination.Acteurs)
    val viewModel = MainViewModel()


    Scaffold(
        bottomBar = {
            BottomNavigation {
                destinations.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(screen.icon, contentDescription = null) },
                        label = { Text(screen.label) },
                        selected =
                        currentDestination?.hierarchy?.any { it.route == screen.destination } == true,
                        onClick = { navController.navigate(screen.destination) })
                }
            }
        }) { innerPadding ->
        NavHost(
            navController, startDestination = Destination.Profile.destination,
            Modifier.padding(innerPadding)
        ) {
            composable(Destination.Profile.destination) {
                Profile(windowClass) {
                    navController.navigate(
                        "films"
                    )
                }
            }
            composable(Destination.Films.destination) { Films(viewModel, navController) }
            composable(Destination.Series.destination) { Series(viewModel, navController) }
            composable(Destination.Acteurs.destination) { Acteurs(viewModel, navController) }
            composable(
                "film/{id}"
            ) { backStackEntry ->
                Film(backStackEntry.arguments?.getString("id")?:"",viewModel)
                /* Film(backStackEntry.arguments?.getString("id")?:"") Est très utile pour les id | En gros tu cherches une id et si tu trouve pas tu fais :""*/
            }
        }
    }

}


sealed class Destination(val destination: String, val label: String, val icon: ImageVector) {
    object Profile : Destination("profile", "Profil", Icons.Filled.AccountBox)
    object Films : Destination("films", "Films", Icons.Filled.Home)
    object Series : Destination("series", "Series", Icons.Filled.Star)
    object Acteurs : Destination("acteurs", "Acteurs", Icons.Filled.Person)
    object Film : Destination("film", "Film", Icons.Filled.Home)

}
