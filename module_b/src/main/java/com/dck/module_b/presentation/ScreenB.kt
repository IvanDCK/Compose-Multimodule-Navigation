package com.dck.module_b.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dck.module_b.model.Mobile
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenB(navigateToC: (Mobile) -> Unit, navigateBack: () -> Unit) {

    val screenBViewModel: ScreenBViewModel = koinViewModel()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Screen B") },
                navigationIcon = {
                    IconButton(
                        onClick = { navigateBack() }
                    ) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Screen B")
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { navigateToC(screenBViewModel.injectMobile()) }
            ) {
                Text(text = "Navigate to C")
            }
        }
    }
    
}