package com.example.weather_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.White


import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Preview
@Composable
fun citiesWeather() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(top = 20.dp, start = 16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.backarrow),
                contentDescription = "Back Arrow",
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = "Locations",
                fontSize = 24.sp,
                color = DarkGray,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 16.dp)
            )
            Spacer(modifier = Modifier.width(180.dp))
            Icon(
                painter = painterResource(id = R.drawable.menu),
                contentDescription = "menu",
                modifier = Modifier.size(24.dp)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()

                .padding(top = 20.dp, start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.height(19.dp))
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.DarkGray)) {
                        append("You are currently seeing the results from top places in ")
                    }
                    withStyle(style = SpanStyle(color = Color(0xFFFFC0CB))) {
                        append("India")
                    }
                },
                fontSize = 18.sp,
                color = DarkGray,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.weight(1f)
            )
            Box(
                modifier = Modifier
                    .background(Color.LightGray)

                 
            ) {
                Column() {
                    Text(
                        text = "Add Place",
                        fontSize = 18.sp,
                        color = DarkGray,
                        fontWeight = FontWeight.SemiBold
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.add),
                        contentDescription = "menu",
                        modifier = Modifier.size(45.dp)
                                .padding(start = 25.dp)
                    )
                }
            }
        }


        Spacer(modifier = Modifier.height(25.dp))
        Cards()
        Spacer(modifier = Modifier.height(19.dp))
        Cards1()
        Spacer(modifier = Modifier.height(16.dp))
        MoreCitiesButton()
    }
}





@Composable
fun Cards() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {

        CardUI(
            temperature = "30°C",
            city = "Mumbai",
            resourceId = R.drawable.values,
            humidity = "51%",
            weather = "28, sunny",
        )
    }
}



@Composable
fun CardUI(
    temperature: String,
    city: String,
    resourceId: Int,
    humidity: String,
    weather: String,

){
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),

    ) {
        Row(
            modifier = Modifier
//                .padding(20.dp)
                .background(color = Color(0xFF0077B6))
                .padding(3.dp)


        ) {


            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 20.dp)
                    .padding(top = 20.dp)
            ) {
                Text(
                    text = city,
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )




                Row {
                    Text(
                        text = "humidity",
                        fontSize = 15.sp,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Text(
                        text = humidity,
                        fontSize = 15.sp,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,

                    )
                }
                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color(0xFFFFC0CB))) {
                            append(weather)
                        }
                    },
                    fontSize = 18.sp,
                    color = DarkGray,

                    )
            }
            Box(
                modifier = Modifier
                    .width(110.dp)
                    .padding(10.dp )
                    .height(70.dp)
            ) {
                Image(painter = painterResource(id = resourceId), contentDescription = "")
            }
        }
    }
}



@Composable
fun Cards1() {
    Row(
        modifier = Modifier.background(White)
    ) {
        CardUI1(

            city = "Indore",
            resourceId = R.drawable.values,
            humidity = "35%",
            weather = "24 , smoke"
        )
    }
}


@Composable
fun CardUI1(city: String, resourceId: Int, humidity: String, weather: String,) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp) // Set the elevation to 0 to remove the shadow
    ) {
        Row(
            modifier = Modifier
//
        ) {


            Column(
                modifier = Modifier
                    .weight(1f) // Pushes the text to the right side
                    .padding(20.dp)
            ) {
                Text(
                    text = city,
                    fontSize = 20.sp,
                    color = DarkGray,
                    fontWeight = FontWeight.SemiBold
                )



                Row{
                    Text(
                        text = "humidity",
                        fontSize = 15.sp,
                        color = DarkGray,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.width(16.dp)) // Add some spacing between humidity and weather
                    Text(
                        text = humidity,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.DarkGray
                    )
                }
                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color(0xFF0077B6))) {
                            append(weather)
                        }
                    },
                    fontSize = 18.sp,
                    color = DarkGray,

                )

            }
            Box(
                modifier = Modifier

                    .width(110.dp)
                    .padding(10.dp )
                    .height(70.dp)
            ) {
                Image(painter = painterResource(id = resourceId), contentDescription = "")
            }
        }
    }

}
    @Composable
    fun getTemperature(temperature: String): AnnotatedString.Builder {
        val annotatedString = AnnotatedString.Builder(temperature)
            .apply {
                addStyle(
                    SpanStyle(
                        fontSize = 18.sp,
                        baselineShift = BaselineShift.Superscript
                    ), 2, 3
                )
            }
        return annotatedString
    }

    @Composable
    fun MoreCitiesButton() {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(),
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 6.dp),
                modifier = Modifier
                    .width(150.dp)
                    .height(50.dp)
                    .clip(RoundedCornerShape(4.dp))
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Choose place", fontSize = 14.sp)
                    Spacer(Modifier.width(10.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.moore),
                        contentDescription = "",
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
    }
