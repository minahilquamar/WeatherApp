package com.example.weather_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun WeatherApp() {
    val PrimaryBlue = Color(0xFF9CCC65)
    val weatherData = listOf(
        WeatherInfo("Saturday", R.drawable.sunny, "Sunny"),
        WeatherInfo("Sunday", R.drawable.cloudy, "Cloudy"),
        WeatherInfo("Monday", R.drawable.rainy, "Rainy"),
        WeatherInfo("Tuesday", R.drawable.sunny, "Sunny") // Add more days as needed
    )

    Column {
        // Image at the top
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.weather_image),
                contentDescription = "Weather Image",
                modifier = Modifier.fillMaxWidth()
            )


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Mumbai",
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0077B6)
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.search_icon),
                            contentDescription = "Search Icon",
                            modifier = Modifier.size(30.dp).then(Modifier.background(Color.Transparent)),
                            tint = Color.White
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.setting_icon),
                            contentDescription = "Settings Icon",
                            modifier = Modifier.size(30.dp),
                            tint= Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row {
                        Text(
                            text = "28",
                            fontSize = 60.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Column {
                            Text(
                                text = "°C",
                                fontSize = 16.sp,
                                color = Color(0xFF0077B6)
                            )
                            Spacer(modifier = Modifier.height(34.dp))
                            Text(
                                text = "Sunny",
                                fontSize = 16.sp,

                                modifier = Modifier.align(Alignment.CenterHorizontally),
                                color = Color(0xFF0077B6)
                            )
                        }
                    }

                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "13 Feb,Sat",
                            fontSize = 16.sp,
                            color = Color(0xFFFFC0CB)
                        )

                        Text(
                            text = "2:00 PM",
                            fontSize = 16.sp,
                            color = Color(0xFFFFC0CB)
                        )
                    }
                }

            }
        }


        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            content = {
                items(weatherData) { day ->
                    WeatherCard(day)
                }
            },
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun WeatherCard(weatherInfo: WeatherInfo) {
    Card(
        modifier = Modifier
            .width(100.dp)
        // .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp) ,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(text = weatherInfo.day, fontSize = 11.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = weatherInfo.icon),
                contentDescription = null,
                modifier = Modifier
                    .size(58.dp)
                    .clip(CircleShape)
                    .background(Color.Gray)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = weatherInfo.condition, fontSize = 11.sp )

        }
    }
}

data class WeatherInfo(val day: String, val icon: Int, val condition: String)

@Composable
fun App() {
    WeatherApp()
}

@Preview
@Composable
fun WeatherAppPreview() {
    App()
}