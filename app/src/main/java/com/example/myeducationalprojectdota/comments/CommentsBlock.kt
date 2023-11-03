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
import com.example.myeducationalprojectdota.dotaScreen.SpacerHeight10
import com.example.myeducationalprojectdota.dotaScreen.SpacerHeight15
import com.example.myeducationalprojectdota.dotaScreen.SpacerHeight25
import com.example.myeducationalprojectdota.dotaScreen.SpacerWidth18
import com.example.myeducationalprojectdota.dotaScreen.SpacerWidth8
import com.example.myeducationalprojectdota.ui.theme.ColorPlainText
import com.example.myeducationalprojectdota.ui.theme.DividerColor
import com.example.myeducationalprojectdota.ui.theme.InactiveStarColor
import com.example.myeducationalprojectdota.ui.theme.Typography
import com.example.myeducationalprojectdota.ui.theme.Yellow


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
    ),
    CommentItem(
        avatarImageId = R.drawable.avatar_3,
        AuthorNameId = R.string.commenterName3,
        sendingDateId = R.string.date2,
        commentContentId = R.string.comment3
    )
)
@Composable
fun CommentsBlock() {
    ReviewTitle()

    SpacerHeight10()

    ReviewBar()

    SpacerHeight25()

    CommentsList()
}


@Composable
fun ReviewTitle() {
    Text(
        text = stringResource(id = R.string.review_title),
        fontSize = 16.sp,
        color = Color.White,
        style = Typography.titleLarge
    )
}

@Composable
fun ReviewBar() {
    Row {
        Text(
            text = stringResource(id = R.string.review_value),
            fontSize = 48.sp,
            color = Color.White,
            style = Typography.titleLarge
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
                    activeColor = Yellow,
                    inactiveColor = InactiveStarColor,
                    size = 14.dp)

            }
            Text(
                text = stringResource(id = R.string.number_of_reviews_long),
                fontSize = 12.sp,
                color = ColorPlainText,
                style = Typography.titleSmall
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
fun CommentsList() {
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
                    fontSize = 16.sp,
                    color = Color.White,
                    style = Typography.titleSmall
                )
                SpacerHeight10()
                Text(
                    text = stringResource(id = comments[i].sendingDateId),
                    fontSize = 12.sp,
                    color = ColorPlainText,
                    style = Typography.titleSmall
                )
            }
        }
        SpacerHeight15()

        Text(
            text = stringResource(id = comments[i].commentContentId),
            fontSize = 12.sp,
            color = ColorPlainText,
            style = Typography.titleSmall
        )

        if (i < comments.size - 1) {
            Divider(
                color = DividerColor,
                thickness = 1.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp)
                    .padding(vertical = 24.dp)
            )
        }
    }
}