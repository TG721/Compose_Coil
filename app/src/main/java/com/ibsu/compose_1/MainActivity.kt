package com.ibsu.compose_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ibsu.compose_1.ui.ImageFromURL
import com.ibsu.compose_1.ui.theme.Compose_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_1Theme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Blue),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ImageFromURL(
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/The_forest_near_Blatets%2C_Vinitsa.JPG/1280px-The_forest_near_Blatets%2C_Vinitsa.JPG",
//                        placeholder = R.drawable.baseline_image_24,
                        Modifier
                            .width(100.dp)
                            .height(100.dp),
                        progressColor = Color(255, 0, 0, 255),
                        errorImage = R.drawable.baseline_error_24
                    )

                }
            }
        }
    }
}

