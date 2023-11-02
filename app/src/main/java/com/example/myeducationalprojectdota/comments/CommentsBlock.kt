package com.example.myeducationalprojectdota.comments

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myeducationalprojectdota.R
import com.example.myeducationalprojectdota.SpacerHeight10
import com.example.myeducationalprojectdota.SpacerHeight15
import com.example.myeducationalprojectdota.SpacerHeight25
import com.example.myeducationalprojectdota.SpacerWidth18
import com.example.myeducationalprojectdota.SpacerWidth8
import com.example.myeducationalprojectdota.ui.theme.Colors


val comments = mutableListOf(
    CommentItem(
        avatarImageId = R.drawable.avatar_1,
        AuthorNameId = R.string.commenterName1,
        sendingDateId = R.string.date,
        commentContentId = R.string.comment1
    ),
    CommentItem(
        avatarImageId = R.drawable.avatar_2,
        AuthorNameId = R.string.commenterName2,
        sendingDateId = R.string.date,
        commentContentId = R.string.comment2
    )
)
@Composable
fun CommentsBlock() {
    DrawReviewTitle()

    SpacerHeight10()

    DrawReviewBar()

    SpacerHeight25()

    DrawComments()
}


@Composable
fun DrawReviewTitle() {
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
}

@Composable
fun DrawReviewBar() {
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
        SpacerWidth18()

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
                RatingBar(
                    rating = 4.0f,
                    activeColor = Colors.Yellow,
                    inactiveColor = Colors.InactiveStarColor,
                    size = 14.dp)

            }
            Text(
                text = stringResource(id = R.string.number_of_reviews_long),
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.sk_modernist_regular)),
                    fontWeight = FontWeight(400),
                    color = Colors.ColorPlainText,
                    letterSpacing = 0.5.sp,
                )
            )
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
fun DrawComments() {
    for (i in 0..comments.size-1) {
        Row {
            Image(
                painter = painterResource(id = comments[i].avatarImageId),
                contentDescription = "commentAvatar",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            SpacerWidth8()

            Column {
                Text(
                    text = stringResource(id = comments[i].AuthorNameId),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.sk_modernist_regular)),
                        fontWeight = FontWeight(400),
                        color = Color.White,
                        letterSpacing = 0.5.sp,
                    )
                )
                SpacerHeight10()
                Text(
                    text = stringResource(id = comments[i].sendingDateId),
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.sk_modernist_regular)),
                        fontWeight = FontWeight(400),
                        color = Colors.ColorPlainText,
                        letterSpacing = 0.5.sp,
                    )
                )
            }
        }
        SpacerHeight15()

        Text(
            text = stringResource(id = comments[i].commentContentId),
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 20.sp,
                fontFamily = FontFamily(Font(R.font.sk_modernist_regular)),
                fontWeight = FontWeight(400),
                color = Colors.ColorPlainText, //Color(0xFFA8ADB7),
                letterSpacing = 0.5.sp,
            )
        )

        if (i < comments.size - 1) {
            Divider(
                color = Colors.DividerColor,
                thickness = 1.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp)
                    .padding(vertical = 24.dp)
            )
        }
    }
}