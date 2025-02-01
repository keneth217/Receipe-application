package com.keneth.receipe

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun CategoryDetailScreen(category: Category) {

    Column (modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally){

        Text(text = category.strCategory, textAlign = TextAlign.Center, style = MaterialTheme.typography.headlineLarge)


        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = "${category.strCategory} thumbnail",
            modifier = Modifier.wrapContentSize()
        )
         Text(text = category.strCategoryDescription,
             textAlign = TextAlign.Justify,
             style = MaterialTheme.typography.bodyMedium,
             modifier = Modifier.verticalScroll(rememberScrollState())
         )

    }

}
@Preview(showBackground = true)
@Composable
fun CategoryDetailScreenPreview(){
    CategoryDetailScreen(category = Category(
        "1",
        "Beef",
        "Beef category description",
        "https://www.themealdb.com/images/category/beef.png"
    ))
}