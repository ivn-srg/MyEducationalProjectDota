package com.example.myeducationalprojectdota

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            MainScreen()
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen() {
    val photos = remember { // Создаем список фотографий
        mutableListOf(
            R.drawable.bg_video_preview1,
            R.drawable.bg_video_preview2,
            R.drawable.bg_photo_preview1,
            R.drawable.bg_photo_preview2
        )
    }

    val genresGame = remember {
        mutableListOf(R.string.tag1, R.string.tag2, R.string.tag3)
    }

    Surface  {
        Box (modifier = Modifier
            .background(Color(0xFF050B18))
            .verticalScroll(rememberScrollState())) {
            Image(painter = painterResource(id = R.drawable.bg_header),
                contentDescription = "header",
                modifier = Modifier
                    .width(628.dp)
                    .height(368.07339.dp))

            Column(modifier = Modifier
                .padding(horizontal = 20.dp,)
                .padding(top = 305.dp)) {
                Row {
                    Box (
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .width(88.dp)
                            .height(88.dp)
                            .background(Color.Black)
                            .border(width = 2.dp, color = Color(0XFF1F2430)),
                    ) {
                        Image(painter = painterResource(id = R.drawable.bg_logo),
                            contentDescription = "dota_logo",
                            modifier = Modifier
                                .padding(17.dp)
                                .width(54.dp)
                                .height(54.dp))
                    }
                    Spacer(modifier = Modifier.width(12.dp))

                    Column(
                        modifier = Modifier.padding(top = 38.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.game_name),
                            style = TextStyle(
                                fontSize = 20.sp,
                                lineHeight = 26.sp,
                                fontFamily = FontFamily(Font(R.font.sk_modernist_regular)),
                                fontWeight = FontWeight(700),
                                color = Color.White,
                                letterSpacing = 0.5.sp,
                            )
                        )

                        Row (
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.width(130.dp)
                        ) {
                            RatingBar(rating = 4.0f, activeColor = Color(0XFFF4D144), inactiveColor = Color(0XFF282E3E), size = 13.dp)
                            Text(
                                text = stringResource(id = R.string.number_of_reviews_short),
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontFamily = FontFamily(Font(R.font.sk_modernist_regular)),
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF45454D),
                                    letterSpacing = 0.5.sp,
                                ),
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }

                    }

                }
                Spacer(modifier = Modifier.height(25.dp))

                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    itemsIndexed(genresGame) {_, item ->
                        CreateLabels(item)
                    }
                }

                Spacer(modifier = Modifier.height(25.dp))

                Row {
                    Text(
                        text = stringResource(id = R.string.game_description),
                        modifier = Modifier,
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 19.sp,
                            fontFamily = FontFamily(Font(R.font.sk_modernist_regular)),
                            fontWeight = FontWeight(400),
                            color = Color(0xB2EEF2FB),

                            )
                    )
                }

                Spacer(modifier = Modifier.height(45.dp))

                LazyRow(
                    modifier = Modifier.fillMaxWidth()
//                    contentPadding = PaddingValues(16.dp)
                ) {
                    items(photos.size) { photoIndex ->
                        // Элемент списка (фотография)
                        Image(
                            painter = painterResource(id = photos[photoIndex]),
                            contentDescription = null,
                            modifier = Modifier
                                .width(240.dp)
                                .height(135.dp)
                                .padding(end = 15.dp)
                                .clip(RoundedCornerShape(18.dp))

                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = stringResource(id = R.string.review_title),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.sk_modernist_regular)),
                        fontWeight = FontWeight(700),
                        color = Color.White,
                        letterSpacing = 0.6.sp,
                    )
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row {
                    Text(
                        text = stringResource(id = R.string.review_value),
                        style = TextStyle(
                            fontSize = 48.sp,
                            fontFamily = FontFamily(Font(R.font.sk_modernist_regular)),
                            fontWeight = FontWeight(700),
                            color = Color.White,
                        )
                    )
                    Spacer(modifier = Modifier.width(18.dp))

                    Column (
                        modifier = Modifier
                            .padding(top = 8.dp)
                    ){
                        Row (
                            modifier = Modifier
                                .width(100.dp)
                                .height(20.dp),
//                            horizontalArrangement = Arrangement.Start
                        ){
                            RatingBar(rating = 4.0f, activeColor = Color(0XFFF4D144), inactiveColor = Color(0XFF282E3E), size = 13.dp)

                        }
                        Text(
                            text = stringResource(id = R.string.number_of_reviews_long),
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.sk_modernist_regular)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFFA8ADB7),
                                letterSpacing = 0.5.sp,
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))

                // TODO: Сделай lazycolumn на следующем этапе
                Column {
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.avatar_1),
                            contentDescription = "avatar_1",
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                text = stringResource(id = R.string.commenter1),
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontFamily = FontFamily(Font(R.font.sk_modernist_regular)),
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFFFFFFFF),
                                    letterSpacing = 0.5.sp,
                                ))
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = stringResource(id = R.string.date),
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontFamily = FontFamily(Font(R.font.sk_modernist_regular)),
                                    fontWeight = FontWeight(400),
                                    color = Color(0x66FFFFFF),

                                    letterSpacing = 0.5.sp,
                                )
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = stringResource(id = R.string.comment1),
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 20.sp,
                            fontFamily = FontFamily(Font(R.font.sk_modernist_regular)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFFA8ADB7),

                            letterSpacing = 0.5.sp,
                        )
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))
                Divider(
                    color = Color(0xFF1A1F29),
                    thickness = 1.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp)
                        .padding(vertical = 24.dp)
                )

                Column {
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.avatar_2),
                            contentDescription = "avatar_2",
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                text = stringResource(id = R.string.commenter2),
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontFamily = FontFamily(Font(R.font.sk_modernist_regular)),
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFFFFFFFF),
                                    letterSpacing = 0.5.sp,
                                ))
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = stringResource(id = R.string.date),
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontFamily = FontFamily(Font(R.font.sk_modernist_regular)),
                                    fontWeight = FontWeight(400),
                                    color = Color(0x66FFFFFF),

                                    letterSpacing = 0.5.sp,
                                )
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = stringResource(id = R.string.comment2),
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 20.sp,
                            fontFamily = FontFamily(Font(R.font.sk_modernist_regular)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFFA8ADB7),
                            letterSpacing = 0.5.sp,
                        )
                    )
                }

                Row (modifier = Modifier.padding(vertical = 40.dp)) {
                    TextButton(
                        onClick = { writeLogs() },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(64.dp)
                            .background(
                                color = Color(0xFFF4D144),
                                shape = RoundedCornerShape(size = 12.dp)
                            )

                    ) {
                        Text(text = stringResource(id = R.string.text_of_button),
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = FontFamily(Font(R.font.sk_modernist_regular)),
                                fontWeight = FontWeight(700),
                                color = Color(0xFF050B18),

                                letterSpacing = 0.6.sp,
                            ))

                    }
                }
            }

        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun CreateLabels(genre: Int) {
    Chip(
        onClick = {},
        content = {
            Text(
                text = stringResource(id = genre),
                color = Color(0xFF44A9F4)
            )
        },
        colors = ChipDefaults.chipColors(
            backgroundColor = Color(0x3D44A9F4)
        ),
        modifier = Modifier
            .height(25.dp)
    )
}

private fun writeLogs(){
    print("The button has pressed")
}

@Composable
fun RatingBar(rating: Float, maxRating: Int = 5, activeColor: Color, inactiveColor: Color, size: Dp) {
    Row(
//        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        for (i in 0 until maxRating) {
            val icon = if (i < rating) Icons.Default.Star else Icons.Outlined.Star
            val color = if (i < rating) activeColor else inactiveColor
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = color,

                modifier = Modifier.size(size)
            )
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()

}