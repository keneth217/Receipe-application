package com.keneth.receipe

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter


@Composable
fun CategoriesScreen(modifier: Modifier = Modifier) {

    val categoryViewModel: MainVewModel = viewModel()
    val viewState by categoryViewModel.categoriesState

    Box(modifier = modifier.fillMaxSize()) {
        if (viewState.isLoading) {
            CircularProgressIndicator(modifier.align(Alignment.Center))
        } else if (viewState.error != null) {
            Text(text = viewState.error!!, modifier = modifier.align(Alignment.Center))
        } else {
            //display categories
            CategoryList(categories = viewState.categoriesList)
        }
    }
}


@Composable
fun CategoryList(categories: List<Category>) {
    LazyVerticalGrid(GridCells.Fixed(3), modifier = Modifier.fillMaxSize()) {
        items(categories.size) { index ->
            println(categories[index])
            println(categories.size)
            CategoryItem(category = categories[index])
        }
    }
}

@Composable
fun CategoryItem(category: Category) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Card(
            modifier = Modifier.padding(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {

            Image(
                painter = rememberAsyncImagePainter(category.strCategoryThumb),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(1f)


            )
            Text(
                text = category.strCategory,
                color = Color.Black,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.align(Alignment.CenterHorizontally).padding( 3.dp)
            )
//            Text(
//                text = category.strCategoryDescription,
//                color = Color.Black,
//                style = TextStyle(
//                    fontSize = 20.sp,
//                    fontWeight = FontWeight.Bold
//                ),
//                modifier = Modifier.align(Alignment.CenterHorizontally).padding( 3.dp)
//            )
        }
    }

}