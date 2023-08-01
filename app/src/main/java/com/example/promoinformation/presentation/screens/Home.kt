package com.example.promoinformation.presentation.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.core.model.model.Promo
import com.example.promoinformation.presentation.viewmodel.HomeViewModel
import com.example.promoinformation.ui.navigation.Screens

@Composable
fun Home(navController: NavController, homeViewModel: HomeViewModel) {

    LaunchedEffect(Unit) {
        homeViewModel.getPromos()
    }
    val uiState = homeViewModel.uiState.collectAsState()

    // Render the UI based on the current state
    when (val state = uiState.value) {
        is HomeViewModel.MainUiState.Success -> {
            Log.d("STATE", "SUCCESS")
            // Render UI for success state, e.g., display the data
            val data = state.data
            Promos(promos = data, navController = navController)
        }

        is HomeViewModel.MainUiState.Loading -> {
            // Render UI for loading state, e.g., show loading indicator
            Log.d("STATE", "LOADINF")

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Loading...")
            }
        }

        is HomeViewModel.MainUiState.Failed -> {
            // Render UI for failure state, e.g., show error message
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Error: ${state.failure}")
            }
        }
    }
}

@Composable
private fun Promos(
    navController: NavController,
    modifier: Modifier = Modifier, promos: List<Promo>
) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        itemsIndexed(items = promos) { index, it ->
            PromoItem(navController, it, index)
        }
    }
}

@Composable
fun PromoContent(promo: Promo) {
    Row(
        modifier = Modifier
            .padding(12.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(
                text = promo.name ?: "", style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.Medium
                )
            )
            Spacer(modifier = Modifier.heightIn(8.dp))
            Image(
                painter = rememberImagePainter(data = promo.img),
                contentDescription = "Image from URL",
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(150.dp), // Set the size of the image
                contentScale = ContentScale.Fit
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PromoItem(navController: NavController, promo: Promo, index: Int) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ), modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
        onClick = {
            navController.navigate("${Screens.Detail.route}/$index")
        }
    ) {
        PromoContent(promo)
    }
}