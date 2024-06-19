package com.schedule.quickschedule

import android.os.Bundle
import android.widget.ListView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.schedule.quickschedule.ui.activity.MainView
import com.schedule.quickschedule.ui.components.AddDialog
import com.schedule.quickschedule.ui.theme.QuickScheduleTheme
import com.schedule.quickschedule.ui.viewmodel.TaskModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuickScheduleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ScaffoldActivity(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldActivity(modifier: Modifier = Modifier) {

    var navController = rememberNavController()

    val viewModel = TaskModel()
    val scope = rememberCoroutineScope()
    val openDialog = remember {
        mutableStateOf(false)
    }

    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(text = "Quick Schedule")
            },
            navigationIcon = {
                Icon(Icons.Filled.Menu, contentDescription = "ic_menu")
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                titleContentColor = MaterialTheme.colorScheme.tertiary
            ),
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.Person, contentDescription = null)
                }
            }
        )
    },
        bottomBar = {
            BottomAppBar(
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Home, contentDescription = Icons.Filled.Home.toString())
                    }
                    IconButton(onClick = {
                    }) {
                        Icon(Icons.Filled.Done, contentDescription = null)
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.DateRange, contentDescription = null)
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = {
                            openDialog.value = !openDialog.value
                        },
                        containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                    ) {
                        Icon(Icons.Filled.Add, contentDescription = "description" )
                    }
                }
            )
        }
    ) { innerPadding -> Column(
        modifier = Modifier.padding(innerPadding),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        NavHost(navController = navController, startDestination = "listView") {
            composable("listView") { MainView(navController)}
            composable("login") {}
            composable("register") {}
        }

        when {
            openDialog.value -> {
                AddDialog(onDismissRequest = {
                    openDialog.value = false
                }, onConfirmation = {

                }, onCancel = {
                    openDialog.value = false
                }, viewModel = viewModel,
                    dialogTitle = "add")
            }
        }
    }
    }
}

@Preview(showBackground = true)
@ExperimentalMaterial3Api
@Composable
fun GreetingPreview() {
    QuickScheduleTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            ScaffoldActivity(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

