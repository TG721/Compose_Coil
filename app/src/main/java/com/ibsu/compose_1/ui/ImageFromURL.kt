package com.ibsu.compose_1.ui

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest


@Composable
fun ImageFromURL(
    link: String,
    modifier: Modifier = Modifier,
//    placeholder: Int? = null,
    errorImage: Int? = null,
    contentDescription: String? = null,
    crossFadeEnabled: Boolean = false,
    progressColor: Color = MaterialTheme.colorScheme.primary,
) {
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current).apply {
//            placeholder?.let { placeholder(it) }
            errorImage?.let {error(it)}
            data(link)
            crossfade(crossFadeEnabled)
        }
//        .data(link)
//        .crossfade(crossFadeEnabled)
        .build(),
    contentDescription = contentDescription,
    contentScale = ContentScale.Crop,
    modifier = modifier,
        loading = {
        CircularProgressIndicator(color = progressColor)
    }
    )
}


@Preview(showBackground = true)
@Composable
fun ShowImage() {
    ImageFromURL(
        "https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/The_forest_near_Blatets%2C_Vinitsa.JPG/1280px-The_forest_near_Blatets%2C_Vinitsa.JPG",
//        placeholder = R.drawable.baseline_image_24
    )
}
