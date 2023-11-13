package com.example.profilpa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.profilpa.Profile
import com.example.profilpa.ui.theme.ProfilPATheme

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val windowSizeClass = calculateWindowSizeClass(this)
            ProfilPATheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                }
                Navigation(windowSizeClass)
            }
        }
    }
}


@Composable
fun Navigation(windowClass: WindowSizeClass){
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val destinations = listOf(Destination.Profile, Destination.Film)

    Scaffold(
        bottomBar = { BottomNavigation {
            destinations.forEach { screen ->
                BottomNavigationItem(
                    icon = { Icon(screen.icon, contentDescription = null) },
                    label = { Text(screen.label) },
                    selected =
                    currentDestination?.hierarchy?.any { it.route == screen.destination } == true,
                    onClick = { navController.navigate(screen.destination) })
            }}
        }) { innerPadding ->
        NavHost(navController, startDestination = Destination.Profile.destination,
            Modifier.padding(innerPadding)) {
            composable(Destination.Profile.destination) { Profile(windowClass) }
            composable(Destination.Film.destination) { Film() }
        }
    }
}

sealed class Destination(val destination: String, val label: String, val icon: ImageVector) {
    object Profile : Destination("profile", "Profil", Icons.Filled.Person)
    object Film : Destination("film", "Film", Icons.Filled.Edit)
}
