package com.example.kalkulator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kalkulator.ui.theme.KalkulatorTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KalkulatorTheme {
                KalkulatorScreen()
            }
        }
    }
}

@Composable
fun KalkulatorScreen() {

    // zmienne
    var num1 by rememberSaveable { mutableStateOf("") }
    var num2 by rememberSaveable { mutableStateOf("") }
    var result by rememberSaveable { mutableStateOf("N/A") }

    val configuration = LocalConfiguration.current
    val isPortrait = configuration.orientation == android.content.res.Configuration.ORIENTATION_PORTRAIT

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center, //centrowanie
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = if (isPortrait) 40.dp else 0.dp)
            .padding(horizontal = 24.dp)
    ) {

        // Pole 1
        OutlinedTextField(
            value = num1,
            onValueChange = { num1 = it },
            label = { Text("Enter first number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Pole 2
        OutlinedTextField(
            value = num2,
            onValueChange = { num2 = it },
            label = { Text("Enter second number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        // przyciski
        Row(modifier = Modifier.fillMaxWidth()) {

            Button(
                onClick = { result = calculate(num1, num2, "+") },
                modifier = Modifier.weight(1f),
                shape = RectangleShape
            ) { Text("+") }

            Spacer(modifier = Modifier.width(12.dp))

            Button(
                onClick = { result = calculate(num1, num2, "-") },
                modifier = Modifier.weight(1f),
                shape = RectangleShape
            ) { Text("-") }

            Spacer(modifier = Modifier.width(12.dp))

            Button(
                onClick = { result = calculate(num1, num2, "*") },
                modifier = Modifier.weight(1f),
                shape = RectangleShape
            ) { Text("*") }

            Spacer(modifier = Modifier.width(12.dp))

            Button(
                onClick = { result = calculate(num1, num2, "/") },
                modifier = Modifier.weight(1f),
                shape = RectangleShape
            ) { Text("/") }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Result: $result",
            fontSize = 28.sp,
            textAlign = TextAlign.Center
        )
    }
}

// Funkcja licząca wynik
fun calculate(a: String, b: String, op: String): String {
    val n1 = a.toIntOrNull()
    val n2 = b.toIntOrNull()

    if (n1 == null || n2 == null) return "Invalid input"

    return when (op) {
        "+" -> (n1 + n2).toString()
        "-" -> (n1 - n2).toString()
        "*" -> (n1 * n2).toString()
        "/" -> if (n2 == 0) "error: division by 0" else (n1 / n2).toString()
        else -> "?"
    }
}
