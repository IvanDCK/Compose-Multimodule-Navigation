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
import com.dck.module_b.presentation.model.Mobile


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenC(mobile: Mobile, navigateToHome: () -> Unit, navigateBack: () -> Unit) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Screen C") },
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
            Text(text = "Screen C")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = mobile.model)
            Text(text = mobile.color)
            Text(text = mobile.screenSize.toString())
            Text(text = mobile.price.toString())
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { navigateToHome() }
            ) {
                Text(text = "Navigate to Home")
            }
        }
    }

}