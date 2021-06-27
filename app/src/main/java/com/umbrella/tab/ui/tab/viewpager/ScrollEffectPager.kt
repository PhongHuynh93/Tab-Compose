package com.umbrella.tab.ui.tab.viewpager

import android.graphics.PorterDuff
import android.widget.ImageView
import android.widget.RatingBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.compose.ui.viewinterop.AndroidView
import coil.load
import com.flaviofaria.kenburnsview.KenBurnsView
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import com.umbrella.tab.R
import kotlin.math.absoluteValue


@OptIn(ExperimentalPagerApi::class)
@Composable
fun ScrollEffectPager() {
    val pagerState = rememberPagerState(
        pageCount = places.size,
        // We increase the offscreen limit, to allow pre-loading of images
        initialOffscreenLimit = 2,
    )

    Column {
        Text(
            text = "Discover",
            style = MaterialTheme.typography.h3,
            modifier = Modifier.padding(start = 16.dp, top = 40.dp),
            fontWeight = FontWeight.Black
        )
        Text(
            text = "Places",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(start = 16.dp),
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.Black
        )
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = 40.dp,
                    bottom = 40.dp
                ),
        ) { page ->
            Card(
                modifier = Modifier
                    .graphicsLayer {
                        // Calculate the absolute offset for the current page from the
                        // scroll position. We use the absolute value which allows us to mirror
                        // any effects for both directions
                        val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                        // We animate the scaleX + scaleY, between 85% and 100%
                        lerp(
                            start = 0.85f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        ).also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }
                    }
                    .fillMaxWidth()
                    .padding(
                        start = 12.dp,
                        end = 12.dp,
                    ),
                shape = RoundedCornerShape(24.dp),
            ) {
                val place = places[page]
                Box {
                    val customView = KenBurnsView(LocalContext.current).also { imageView ->
                        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
                        imageView.load(place.url)
                    }
                    AndroidView(
                        factory = { customView },
                        modifier = Modifier.fillMaxSize()
                    )
                    Box(
                        Modifier
                            .fillMaxSize()
                            .background(Color(android.graphics.Color.parseColor("#80000000")))
                    ) {}

                    Column(
                        Modifier
                            .align(Alignment.BottomStart)
                            .padding(16.dp)
                    ) {

                        Text(
                            text = place.title,
                            style = MaterialTheme.typography.h5,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )

                        val ratingBar = RatingBar(
                            LocalContext.current, null, R.attr.ratingBarStyleSmall
                        ).apply {
                            rating = place.rating
                            progressDrawable.setColorFilter(
                                android.graphics.Color.parseColor("#ff8800"),
                                PorterDuff.Mode.SRC_ATOP
                            )
                        }
                        AndroidView(
                            factory = { ratingBar },
                            modifier = Modifier.padding(top = 8.dp)
                        )
                        Text(
                            text = place.description,
                            style = MaterialTheme.typography.body1,
                            color = Color.White,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ScrollEffectPagerPreview() {
    Surface(color = MaterialTheme.colors.background) {
        ScrollEffectPager()
    }
}

data class Places(val title: String, val description: String, val rating: Float, val url: String)

val places = listOf(
    Places(
        "Tuvalu",
        "Tuvalu, in the South Pacific, is an independent island nation within the British Commonwealth. Its 9 islands comprise small, thinly populated atolls and reef islands with palm-fringed beaches and WWII sites.",
        5f,
        "https://images.unsplash.com/photo-1483683804023-6ccdb62f86ef?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=675&q=80"
    ),
    Places(
        "Los Angles",
        "Los Angeles is a sprawling Southern California city and the center of the nation’s film and television industry. Near its iconic Hollywood sign, studios such as Paramount Pictures, Universal and Warner Brothers offer behind-the-scenes tours.",
        4.5f,
        "https://images.unsplash.com/photo-1554143091-c41d76e3da15?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=675&q=80"
    ),
    Places(
        "China",
        "China, officially the People's Republic of China, is a country in East Asia and is the world's most populous country, with a population of around 1.428 billion in 2017.",
        4.5f,
        "https://images.unsplash.com/photo-1529921879218-f99546d03a9d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=675&q=80"
    ),
    Places(
        "Tokyo",
        "Tokyo, Japan’s busy capital, mixes the ultramodern and the traditional, from neon-lit skyscrapers to historic temples. The opulent Meiji Shinto Shrine is known for its towering gate and surrounding woods.",
        3.5f,
        "https://images.unsplash.com/photo-1540959733332-eab4deabeeaf?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1071&q=80"
    )
)
