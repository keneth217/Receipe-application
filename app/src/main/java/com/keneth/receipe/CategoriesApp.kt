package com.keneth.receipe

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun CategoryApp(
    navController: NavHostController,
    modifier: Modifier = Modifier
        .fillMaxSize()
        .padding(top = 16.dp)
) {
    val categoriesViewModel: MainVewModel = viewModel()
    val viewState by categoriesViewModel.categoriesState
    NavHost(navController = navController, startDestination = Screen.CategoryScreen.route) {
        composable(Screen.CategoryScreen.route) {
            CategoriesScreen(
                viewState = viewState,
                navigateToCategoryDetails = {

                    navController.currentBackStackEntry?.savedStateHandle?.set("category", it)
                    navController.navigate(Screen.CategoryDetailScreen.route)
                }
            )
        }
        composable(route = Screen.CategoryDetailScreen.route) {
            val category =
                navController.previousBackStackEntry?.savedStateHandle?.get<Category>("category")
                    ?: Category("", "", "", "")
            CategoryDetailScreen(category = category)
        }


    }


}