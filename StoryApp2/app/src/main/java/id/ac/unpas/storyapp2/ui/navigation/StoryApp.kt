package id.ac.unpas.storyapp2.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import id.ac.unpas.storyapp2.ui.screen.LoginScreen
import id.ac.unpas.storyapp2.viewmodel.AuthViewModel

@Composable
fun StoryApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            val viewModel: AuthViewModel = hiltViewModel()
            LoginScreen(
                viewModel = viewModel,
                onSuccess = {
                    navController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            )
        }
        composable("home") {
            // Tambahkan HomeScreen di sini nanti
        }
    }
}