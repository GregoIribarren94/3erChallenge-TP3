package com.example.a3er_challenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a3er_challenge.ui.theme._3er_ChallengeTheme
import com.example.a3er_challenge.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.loadQuotes()

        enableEdgeToEdge()
        setContent {
            _3er_ChallengeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Quote(
                        quote    = viewModel.Quote.value,
                        author   = viewModel.Author.value,
                        category = viewModel.Category.value,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Quote(
    quote: String,
    author: String,
    category: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(all = 16.dp)) {
        Text(
            text = quote,
            modifier = Modifier
        )
        Text(
            text = author,
            modifier = Modifier
        )
        Text(
            text = category,
            modifier = Modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _3er_ChallengeTheme {
        Quote("Quote...", author = "Author", category = "Category")
    }
}