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
import com.example.myeducationalprojectdota.ui.theme.BorderLogoColor
import com.example.myeducationalprojectdota.ui.theme.ColorPlainText
import com.example.myeducationalprojectdota.ui.theme.InactiveStarColor
import com.example.myeducationalprojectdota.ui.theme.NumersReviewColor
import com.example.myeducationalprojectdota.ui.theme.Typography
import com.example.myeducationalprojectdota.ui.theme.Yellow
import com.example.myeducationalprojectdota.ui.theme.tagsBgColor
import com.example.myeducationalprojectdota.ui.theme.tagsTextColor


val photos = mutableListOf(
        PhotoItem(id = R.drawable.bg_video_preview1, isVideo = true),
        PhotoItem(id = R.drawable.bg_video_preview2, isVideo = true),
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
            Logo()

            SpacerWidth12()

            GameName()
        }
        SpacerHeight25()

        Labels()

        SpacerHeight25()

        GameDescription()

        SpacerHeight40()

        MediaList()

        SpacerHeight25()

        CommentsBlock()

        InstallButton()
    }
}




@Composable
fun Logo() {
    Box (
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .width(88.dp)
            .height(88.dp)
            .background(Color.Black)
            .border(width = 2.dp, color = BorderLogoColor),
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
fun GameName() {
    Column(
        modifier = Modifier.padding(top = 38.dp)
    ) {
        Text(
            text = stringResource(id = R.string.game_name),
            fontSize = 20.sp,
            color = Color.White,
            style = Typography.titleLarge
        )

        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(130.dp)
        ) {
            RatingBar(
                rating = 4.0f,
                activeColor = Yellow,
                inactiveColor = InactiveStarColor,
                size = 13.dp)
            Text(
                text = stringResource(id = R.string.number_of_reviews_short),
                fontSize = 12.sp,
                color = NumersReviewColor,
                style = Typography.titleSmall,
                modifier = Modifier.padding(start = 5.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun Labels() {
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
                        color = tagsTextColor,
                        fontSize = 12.sp,
                        style = Typography.labelSmall
                    )
                },
                colors = ChipDefaults.chipColors(
                    backgroundColor = tagsBgColor
                ),
                modifier = Modifier
                    .height(25.dp)
            )
        }
    }
}

@Composable
fun GameDescription() {
    Row {
        Text(
            text = stringResource(id = R.string.game_description),
            fontSize = 12.sp,
            color = ColorPlainText,
            style = Typography.titleSmall
        )
    }
}

@Composable
fun MediaList() {
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
                            .background(Color(0x4DFFFFFF))

                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_videoplayer),
                        contentDescription = "Иконка проигрывателя",
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(12.dp)
                    )
//                    Icon(
//                        imageVector = Icons.Default.PlayArrow,
//                        contentDescription = null,
//                        tint = Color.White,
//                        modifier = Modifier
//                            .align(Alignment.Center)
//                    )
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
fun InstallButton() {
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
                    color = Yellow,
                    shape = RoundedCornerShape(size = 12.dp)
                )
        ) {
            Text(
                text = stringResource(id = R.string.text_of_button),
                fontSize = 24.sp,
                color = Color.Black,
                style = Typography.titleLarge
            )
        }
    }
}