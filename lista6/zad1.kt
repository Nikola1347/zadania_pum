package com.example.websitelist

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.websitelist.ui.theme.WebsiteListTheme
import androidx.compose.foundation.lazy.items

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WebsiteList()
        }
    }
}

@Composable
fun WebsiteList() {

    // lista
    val websites = listOf(
        "https://www.google.com",
        "https://developer.android.com",
        "https://kotlinlang.org",
        "https://youtube.com"
    )

    val context = LocalContext.current //pobranie kontekstu aktualnej aktywności

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(26.dp)
    ) {

        items(websites) { url ->

            Text(
                text = url,
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .clickable {
                        val intent = Intent(Intent.ACTION_VIEW) //otwórz coś w odpowiedniej aplikacji
                        intent.data = Uri.parse(url) //zamiana string na uri
                        context.startActivity(intent) //uruchamianie aktywności
                    }
            )
        }
    }
}