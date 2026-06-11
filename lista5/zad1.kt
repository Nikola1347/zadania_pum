package com.example.counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.counter.ui.theme.CounterTheme
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterTheme {
                CounterScreen()
            }
        }
    }
}

@Composable
fun CounterScreen() {

    var counter by rememberSaveable { mutableIntStateOf(0) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().padding(bottom = 40.dp)
    ){
        Spacer(modifier = Modifier.weight(0.3f))

        //liczba
        Text(
            text = counter.toString(),
            fontSize = 200.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f)
        )

        //przycisk reset
        Button(
            onClick = { counter = 0 },
            shape = RectangleShape,
            modifier = Modifier.fillMaxWidth().padding(1.dp)
        ){
            Text("Reset")
        }

        Row(modifier = Modifier.fillMaxWidth()) {

            //przycisk -
            Button(
                onClick = { counter-- },
                shape = RectangleShape,
                modifier = Modifier.weight(1f).padding(1.dp)
            ) {
                Text("Count down")
            }

            //przycisk +
            Button(
                onClick = { counter++ },
                shape = RectangleShape,
                modifier = Modifier.weight(1f).padding(1.dp)
            ) {
                Text("Count Up")
            }
        }
    }
}