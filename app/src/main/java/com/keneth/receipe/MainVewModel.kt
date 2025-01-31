package com.keneth.receipe;


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainVewModel : ViewModel() {
    private val _categoriesState = mutableStateOf(CategoriesState())
    val categoriesState: State<CategoriesState> = _categoriesState


    init {
        fetchCategories()
    }


    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                val response = reciepService.getCategories()
                _categoriesState.value = _categoriesState.value.copy(
                    categoriesList = response.categories, isLoading = false, error = null
                )

            } catch (e: Exception) {
                _categoriesState.value = _categoriesState.value.copy(
                    isLoading = false, error = "Error fetching categories ${e.message}"
                )
            }
        }
    }

    data class CategoriesState(
        val categoriesList: List<Category> = emptyList(),
        val isLoading: Boolean = false,
        val error: String? = null
    )
}
