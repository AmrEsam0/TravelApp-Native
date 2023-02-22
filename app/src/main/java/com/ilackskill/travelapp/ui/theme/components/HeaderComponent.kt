package com.ilackskill.travelapp.ui.theme.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HeaderComponent(modifier: Modifier = Modifier) {
	Box(modifier = modifier.fillMaxWidth()) {
		Column(modifier = modifier) {
			Text(text = "Hello World")
			Text(text = "Hello World")
		}
	}
}