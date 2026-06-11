package com.example.assignments

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument

// MODELE DANYCH
data class Task(
    val id: Int,
    val description: String,
    val maxPoints: Int
)

data class AssignmentList(
    val id: String,
    val subject: String,
    val listNumber: Int,
    val grade: Double,
    val tasks: List<Task>
)

// DANE
val sampleAssignmentLists = listOf(
    AssignmentList("PUM1_L1", "Programowanie Urządzeń Mobilnych 1", 1, 4.5, listOf(
        Task(1, "Zad 1", 3),
        Task(2, "Zad 2", 3),
        Task(3, "Zad 3", 4)
    )),
    AssignmentList("PUM1_L2", "Programowanie Urządzeń Mobilnych 1", 2, 5.0, listOf(
        Task(1, "Zad 1", 4),
        Task(2, "Zad 2", 6)
    )),
    AssignmentList("SO_L1", "Systemy Operacyjne", 1, 3.5, listOf(
        Task(1, "Zad 1", 5),
        Task(2, "Zad 2", 5)
    )),
    AssignmentList("SO_L2", "Systemy Operacyjne", 2, 4.0, listOf(
        Task(1, "Zad 1", 6),
        Task(2, "Zad 2", 4)
    ))
)

// MAIN ACTIVITY
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignments()
        }
    }
}

// GŁÓWNA APLIKACJA
@Composable
fun Assignments() {

    val navController = rememberNavController() //obiekt który pozwala przełączać ekrany

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = navController.currentDestination?.route == "lists",
                    onClick = { navController.navigate("lists") },
                    label = { Text("Listy") },
                    icon = { Text("\uD83D\uDCC4") }
                )
                NavigationBarItem(
                    selected = navController.currentDestination?.route == "grades",
                    onClick = { navController.navigate("grades") },
                    label = { Text("Oceny") },
                    icon = { Text("⭐") }
                )
            }
        }
    ) { padding -> //Scaffold musi odsunąć zawartość żeby pasek jej nie przykrył

        NavHost(
            navController = navController,
            startDestination = "lists",
            modifier = Modifier.padding(padding)
        ) {

            composable("lists") {
                AssignmentListsScreen(navController)
            }

            composable("grades") {
                GradesSummaryScreen()
            }

            composable(
                "details/{listId}", //adres ekranu
                arguments = listOf(navArgument("listId") { type = NavType.StringType })
            ) { backStackEntry ->
                val id = backStackEntry.arguments?.getString("listId")!!
                ListDetailScreen(id)
            }
        }
    }
}

// EKRAN 1 - LISTY
@Composable
fun AssignmentListsScreen(navController: NavController) {

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        items(sampleAssignmentLists) { list ->

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .clickable {
                        navController.navigate("details/${list.id}")
                    }
            ) {
                Text(text = list.subject, fontSize = 20.sp)
                Text(text = "Ocena: ${list.grade}")
                Text(text = "Zadań: ${list.tasks.size}")
            }

            Divider()
        }
    }
}

// EKRAN 2 - OCENY
@Composable
fun GradesSummaryScreen() {

    val grouped = sampleAssignmentLists.groupBy { it.subject }

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        grouped.forEach { (subject, lists) ->

            val avg = lists.map { it.grade }.average()

            item {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(text = subject, fontSize = 20.sp)
                    Text(text = "Średnia ocen: ${"%.2f".format(avg)}")
                }
                Divider()
            }
        }
    }
}

// EKRAN 3 - SZCZEGÓŁY LISTY
@Composable
fun ListDetailScreen(listId: String) {

    val list = sampleAssignmentLists.find { it.id == listId }

    if (list == null) {
        Text("Nie znaleziono listy")
        return
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        Text(text = "${list.subject} - Lista ${list.listNumber}", fontSize = 22.sp)
        Text(text = "Ocena: ${list.grade}", fontSize = 18.sp)

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(list.tasks) { task ->
                Column(modifier = Modifier.padding(12.dp)) {
                    Text("Zadanie ${task.id}", fontSize = 18.sp)
                    Text(task.description)
                    Text("Max punktów: ${task.maxPoints}")
                }
                Divider()
            }
        }
    }
}