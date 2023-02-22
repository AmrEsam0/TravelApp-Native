package com.ilackskill.travelapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ilackskill.travelapp.ui.theme.background_light
import com.ilackskill.travelapp.ui.theme.fontFamily
import com.ilackskill.travelapp.ui.theme.screens.HomeScreen

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			val systemUIController = rememberSystemUiController();
			systemUIController.setStatusBarColor(background_light, darkIcons = true)
//			this.window.statusBarColor = ContextCompat.getColor(this, R.color.background_light)
			HomeScreen()
		}
	}
}

//AttractionCard(
//title = "Amsterdam",
//photoUrl = "https://picsum.photos/id/257/500/900",
//)
@Composable
fun AttractionCard(
	title: String,
	photoUrl: String,
	modifier: Modifier = Modifier
) {
	var size by remember { mutableStateOf(32.sp) }
	var boxSize by remember { mutableStateOf(1f) }
	Box(
		modifier = Modifier
			.fillMaxWidth(boxSize)
			.padding(12.dp)
			.animateContentSize(animationSpec = spring(dampingRatio = Spring.DampingRatioNoBouncy, 80f))
	) {
		Card(
			modifier = modifier.fillMaxWidth(),
			shape = RoundedCornerShape(8.dp),
			elevation = 6.dp
		) {
			Box(
				modifier = modifier
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
					modifier = modifier
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
					modifier = modifier
						.fillMaxSize()
						.padding(horizontal = 16.dp),
					contentAlignment = Alignment.BottomStart,
				) {
					Row(
						modifier = modifier
							.fillMaxWidth()
							.padding(bottom = 2.dp),
						horizontalArrangement = Arrangement.SpaceBetween,
						verticalAlignment = Alignment.CenterVertically,
					) {
						Text(
							buildAnnotatedString {
								withStyle(style = SpanStyle(fontSize = 32.sp)) {
									append(title.slice(0..0))
								}
								append(title.slice(1 until title.length))
							},
							style = TextStyle(
								color = Color.White,
								fontSize = 20.sp,
								fontFamily = fontFamily,
								fontWeight = FontWeight.Bold,
								letterSpacing = 1.sp,
							)
						)
						Button(
							onClick = {
//								size = if (size == 32.sp) 20.sp else 32.sp;
								boxSize = if (boxSize == 1f) 0.9f else 1f;
							},
						) {
							Text(text = "Explore", fontFamily = fontFamily, color = Color.White);
						}
					}
				}
			}
		}
	}

}