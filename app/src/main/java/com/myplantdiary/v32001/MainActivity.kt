package com.myplantdiary.v32001

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.*
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.myplantdiary.v32001.ui.theme.MyPlantDiaryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPlantDiaryTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background,
                modifier = Modifier.fillMaxWidth()) {
                    SpecimenFacts("Android")
                }
            }
        }
    }
}

@Composable
fun SpecimenFacts(name: String) {
    var plantName by remember { mutableStateOf("")}
    var location by remember { mutableStateOf("")}
    var description by remember { mutableStateOf("")}
    var datePlanted by remember { mutableStateOf("")}
    var context = LocalContext.current
    Column {
        OutlinedTextField(
            value = plantName,
            onValueChange = { plantName = it },
            label = {
                Text(
                    stringResource(R.string.plantName)
                )
            },
            modifier = Modifier.fillMaxWidth())
        OutlinedTextField(
            value = location,
            onValueChange = { location = it },
            label = {
                Text(
                    stringResource(R.string.location)
                )
            },
            modifier = Modifier.fillMaxWidth())
        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = {
                Text(
                    stringResource(R.string.description)
                )
            },
            modifier = Modifier.fillMaxWidth())
        OutlinedTextField(
            value = datePlanted,
            onValueChange = { datePlanted = it },
            label = {
                Text(
                    stringResource(R.string.datePlanted)
                )
            },
            modifier = Modifier.fillMaxWidth())
        Button(onClick = {
            Toast.makeText(context, "$plantName $location $description $datePlanted", Toast.LENGTH_LONG).show()
        },
        content = {Text(text = "save")})
    }
}

@Preview(name="Light Mode", showBackground=true)
@Preview(uiMode=Configuration.UI_MODE_NIGHT_YES, showBackground = true, name="Dark Mode")
@Composable
fun DefaultPreview() {
    MyPlantDiaryTheme {
        Surface(color = MaterialTheme.colors.background,
            modifier = Modifier.fillMaxWidth()) {
            SpecimenFacts("Android")
        }
        SpecimenFacts("Android")
    }
}