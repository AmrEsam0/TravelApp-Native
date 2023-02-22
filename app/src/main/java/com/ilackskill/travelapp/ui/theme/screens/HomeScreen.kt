package com.ilackskill.travelapp.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ilackskill.travelapp.ui.theme.background_light
import com.ilackskill.travelapp.ui.theme.components.HeaderComponent

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
	Box(
		modifier = modifier
			.fillMaxSize()
			.background(color = background_light)
			.padding(12.dp)
	) {
		HeaderComponent()
	}

}