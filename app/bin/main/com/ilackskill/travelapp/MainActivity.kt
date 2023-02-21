package com.ilackskill.travelapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ilackskill.travelapp.ui.theme.fontFamily

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContent {

			AttractionCard(
				title = "Amsterdam",
				photoUrl = "https://picsum.photos/id/257/500/900",
			)

		}
	}
}


@Composable
fun AttractionCard(
	title: String,
	photoUrl: String,
	modifier: Modifier = Modifier
) {
	Box(
		modifier = Modifier
			.fillMaxWidth(1f)
			.padding(16.dp)
	) {
		Card(
			modifier = modifier.fillMaxWidth(),
			shape = RoundedCornerShape(8.dp),
			elevation = 6.dp
		) {
			Box(
				modifier = Modifier
					.height(240.dp)
					.background(Color.Green)
			) {
				AsyncImage(
					model = photoUrl,
					contentDescription = null,
					modifier = Modifier.fillMaxSize(),
					contentScale = ContentScale.Crop,
				)
				Box(
					modifier = Modifier
						.fillMaxSize()
						.background(
							brush = Brush.verticalGradient(
								colors = listOf(
									Color.Transparent,
									Color.Black
								),
								startY = 400f,
							)
						)
				)
				Box(
					modifier = Modifier
						.fillMaxSize()
						.padding(12.dp),
					contentAlignment = Alignment.BottomStart,
				) {
					Text(
						title, style = TextStyle(
							color = Color.White,
							fontSize = 20.sp,
							fontFamily = fontFamily,
							fontWeight = FontWeight.Bold,
							letterSpacing = 1.sp,
						)
					)
				}
			}
		}
	}

}