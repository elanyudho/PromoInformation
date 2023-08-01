package com.example.promoinformation.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.promoinformation.presentation.viewmodel.HomeViewModel

@Composable
fun Detail(index: Int, homeViewModel: HomeViewModel) {

    val uiState = homeViewModel.uiState.collectAsState()

    when (val state = uiState.value) {
        is HomeViewModel.MainUiState.Success -> {
            val data = state.data[index]
            Column(modifier = Modifier.fillMaxSize(). padding(16.dp)) {
                Image(
                    painter = rememberImagePainter(data = data.img),
                    contentDescription = "Image from URL",
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.25f), // Set the size of the image
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.heightIn(16.dp))

                Text(text = "Nama Promo: ${data.name ?: ""}", color = Color.Black)

                Spacer(modifier = Modifier.heightIn(8.dp))

                Text(text = "Deskripsi:  ${data.desc ?: ""}")

                Spacer(modifier = Modifier.heightIn(8.dp))

                Text(text = "Lokasi Promo: ${data.location ?: ""}")

                Spacer(modifier = Modifier.heightIn(8.dp))

                Text(text = "Mulai Berlaku: ${data.createdAt ?: ""}")
            }
        }

        else -> {}
    }
}