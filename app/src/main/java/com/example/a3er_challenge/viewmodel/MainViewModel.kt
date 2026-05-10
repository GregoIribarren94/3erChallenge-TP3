package com.example.a3er_challenge.viewmodel


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a3er_challenge.shared.GetServiceQuotes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getQuotesUseCase: GetServiceQuotes
) : ViewModel() {

    var Quote    = mutableStateOf("Cargando...")
    var Author   = mutableStateOf("")
    var Category = mutableStateOf("")

    fun loadQuotes() {
        viewModelScope.launch {
            val quote = getQuotesUseCase.invoke()
            if (!quote.isNullOrEmpty() && quote.size > 0) {
                Quote.value    = quote[0].quote
                Author.value   = quote[0].author
                Category.value = quote[0].category
            }
        }
    }
}
