package com.example.myeducationalprojectdota.dotaScreen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myeducationalprojectdota.R
import com.example.myeducationalprojectdota.comments.CommentsBlock
import com.example.myeducationalprojectdota.ui.theme.Colors


val photos = mutableListOf(
        PhotoItem(id = R.drawable.bg_video_preview1, isVideo = true),
        PhotoItem(id = R.drawable.bg_video_preview2),
        PhotoItem(id = R.drawable.bg_photo_preview1),
        PhotoItem(id = R.drawable.bg_photo_preview2)
    )

val genresGame = mutableListOf(R.string.tag1, R.string.tag2, R.string.tag3)

@Composable
fun DotaScreen() {
    Column(modifier = Modifier
        .padding(horizontal = 20.dp,)
        .padding(top = 305.dp)
    ) {
        Row {
            DrawLogo()

            SpacerWidth12()

            DrawGameName()
        }
        SpacerHeight25()

        CreateLabels()

        SpacerHeight25()

        DrawGameDescription()

        SpacerHeight40()

        DrawMedia()

        SpacerHeight25()

        CommentsBlock()

        DrawInstallButton()
    }
}




@Composable
fun DrawLogo() {
    Box (
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .width(88.dp)
            .height(88.dp)
            .background(Color.Black)
            .border(width = 2.dp, color = Colors.BorderLogoColor),
    ) {
        Image(painter = painterResource(id = R.drawable.bg_logo),
            contentDescription = "dota_logo",
            modifier = Modifier
                .padding(17.dp)
                .width(54.dp)
                .height(54.dp))
    }
}

@Composable
fun DrawGameName() {
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
            RatingBar(
                rating = 4.0f,
                activeColor = Colors.Yellow,
                inactiveColor = Colors.InactiveStarColor,
                size = 13.dp)
            Text(
                text = stringResource(id = R.string.number_of_reviews_short),
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.sk_modernist_regular)),
                    fontWeight = FontWeight(400),
                    color = Colors.NumersReviewColor,
                    letterSpacing = 0.5.sp,
                ),
                modifier = Modifier.padding(start = 5.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun CreateLabels() {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(genresGame) { _, item ->
            Chip(
                onClick = {},
                content = {
                    Text(
                        text = stringResource(id = item),
                        color = Colors.tagsTextColor,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                            fontWeight = FontWeight(500),
                        )
                    )
                },
                colors = ChipDefaults.chipColors(
                    backgroundColor = Colors.tagsBgColor
                ),
                modifier = Modifier
                    .height(25.dp)
            )
        }
    }
}

@Composable
fun DrawGameDescription() {
    Row {
        Text(
            text = stringResource(id = R.string.game_description),
            modifier = Modifier,
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 19.sp,
                fontFamily = FontFamily(Font(R.font.sk_modernist_regular)),
                fontWeight = FontWeight(400),
                color = Colors.ColorPlainText
            )
        )
    }
}

@Composable
fun DrawMedia() {
    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        itemsIndexed(photos) { _, photo ->
            Box (
                modifier = Modifier
                    .padding(end = 15.dp)
            ){
                Image(
                    painter = painterResource(id = photo.id),
                    contentDescription = null,
                    modifier = Modifier
                        .width(240.dp)
                        .height(135.dp)
                        .clip(RoundedCornerShape(18.dp))
                )
                if (photo.isVideo) {
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(40.dp)
                            .align(Alignment.Center)
                            .background(Color(0x2DFFFFFF))

                    )
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
            }
        }
    }
}

@Composable
fun RatingBar(rating: Float, maxRating: Int = 5, activeColor: Color, inactiveColor: Color, size: Dp) {
    Row(
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
fun DrawInstallButton() {
    val context = LocalContext.current.applicationContext

    Row (
        modifier = Modifier
            .padding(vertical = 40.dp)
    ) {
        TextButton(
            onClick = {
                Toast.makeText(context, "The button has tapped", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .background(
                    color = Colors.Yellow,
                    shape = RoundedCornerShape(size = 12.dp)
                )
        ) {
            Text(text = stringResource(id = R.string.text_of_button),
                style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.sk_modernist_regular)),
                    fontWeight = FontWeight(700),
                    color = Color.Black,
                    letterSpacing = 0.6.sp,
                )
            )
        }
    }
}