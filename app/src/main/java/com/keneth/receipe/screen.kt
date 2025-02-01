package com.keneth.receipe

 sealed  class Screen(val route: String) {



     object CategoryScreen : Screen("category_screen")
     object CategoryDetailScreen : Screen("category_detail_screen")



}