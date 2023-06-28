package com.example.managestates

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.SpaceBetween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.reflect.KProperty

@Composable
fun ManageStateScreen() {
    //CounterLayout()
    TodoScreen()
}

@Composable
fun CounterLayout() {

    //val counter = rememberSaveable { mutableStateOf(0) }  //use counter.value if using this method
    //var counter by remember { mutableStateOf(0) }
    val (counter, setcounter) = remember { mutableStateOf(0) }


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "${counter}", fontSize = 25.sp)
        Spacer(modifier = Modifier.height(15.dp))
        Button(onClick = {
            setcounter(counter + 1)
            //counter ++
        }) {
            Text(text = "Counter")
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TodoScreen() {

    //var todoList = mutableListOf("Anjali","Anamika","Anika")
    val todoList = remember { mutableStateListOf("Anjali", "Anamika", "Anika") }
    val scrollState = rememberScrollState()
    val mapData = remember { mutableStateMapOf("1" to "Anjali", 2 to "Anika") }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                todoList.add("New User")
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = ""
                )

            }
        }
    ) {
        Column(
            modifier = Modifier.verticalScroll(scrollState)
        ) {
            todoList.forEach {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, start = 10.dp),
                    horizontalArrangement = SpaceBetween

                ) {
                    Text(text = it)
                    //Text(text = "${mapData["1"]}")
                    IconButton(onClick = {
                        todoList.remove(it)
                    }) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = ""
                        )

                    }

                }
            }

        }

    }
}


