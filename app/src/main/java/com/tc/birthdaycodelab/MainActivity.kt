package com.tc.birthdaycodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tc.birthdaycodelab.ui.theme.BirthdayCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayCodelabTheme {
                
                    GreetingImage(
                        getString(R.string.jetpack_title),
                        getString(R.string.jetpack_intro),
                        getString(R.string.jetpack_body)
                    )

            }
        }
    }

}

@Composable
private fun ContentBody(title: String, intro: String, body: String, modifier: Modifier = Modifier) {
    // A surface container using the 'background' color from the theme
    Column(
        modifier = modifier
    ) {
        Text(
            text = title,
            fontSize = 12.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = intro,
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = body,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }


}

@Composable
fun GreetingImage(title: String, intro: String, body: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
    ){
        Image(
            painter = image,
            contentDescription = null
        )
        ContentBody(
            title = title,
            intro = intro,
            body = body
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BirthdayCodelabTheme {
        GreetingImage(
            stringResource(R.string.jetpack_title),
            stringResource(R.string.jetpack_intro),
            stringResource(R.string.jetpack_body)
        )
    }
}