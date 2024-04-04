package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier : Modifier = Modifier) {

    var slide by remember {
        mutableStateOf(1)
    }

    val gallery = when (slide) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val title = when (slide) {
        1 -> R.string.Lemon_Tree
        2 -> R.string.Lemon
        3 -> R.string.Glass_Of_Lemonade
        else -> R.string.Empty_Glass
    }

    val subtitle = when (slide) {
        1 -> R.string.Author1
        2 -> R.string.Author2
        3 -> R.string.Author3
        else -> R.string.Author4
    }

Column(modifier = Modifier
    .fillMaxSize()
    .padding(top = 100.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        modifier = Modifier
            .size(width = 250.dp, height = 350.dp)
    ){
    val imageResource = painterResource(gallery)
    Image(
        painter = imageResource,
        contentDescription = null,
        modifier = Modifier
            .width(250.dp)
            .height(350.dp)
            //.padding(5.dp)
            .border(BorderStroke(20.dp, Color(0xFFF6EDFF)))
            //.padding(bottom =16.dp)

    )
    }
    Spacer(modifier = Modifier.height(24.dp))

    Column(modifier = Modifier
        .background(Color(0xFFF6EDFF))
        .padding(bottom = 16.dp),
        //.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = stringResource(title),
            fontSize = 16.sp,
            //fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(
                    top = 8.dp,
                    start = 20.dp,
                    end = 20.dp
                )
                .background(Color(0xFFF6EDFF))
        )
        Text(
            text = stringResource(subtitle),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(4.dp)
            )
    }

    Spacer(modifier = Modifier.height(24.dp))

    Row(modifier= Modifier
        .weight(1f)) {
        Button(
            onClick = {
                if (slide == 1) {
                    slide = 1
                }
                if (slide == 2) {
                    slide = 1
                }
                if (slide == 3) {
                    slide = 2
                }
                if (slide == 4) {
                    slide = 3
                }
            }
            ,modifier = Modifier
            .height(40.dp)
            .width(150.dp)) {
            Text(text = "Previous")
            //modifier = Modifier.weight(1f)
        }
        Spacer(modifier = Modifier.width(34.dp))

        Button(onClick =
        {
            if(slide == 1)
            {
                slide = 2
            }
            else if(slide == 2)
            {
                slide = 3
            }
           else if(slide == 3)
            {
                slide = 4
            }
            else if(slide == 4)
            {
                slide = 4
            }
            else
            {
                slide = 1
            }
        }
            ,modifier = Modifier
            .height(40.dp)
            .width(150.dp)) {
            Text(text = "  Next  ")
        }
    }
}
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceAppPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}