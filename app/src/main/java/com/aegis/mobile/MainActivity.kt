package com.aegis.mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AegisApp()
        }
    }
}

@Composable
fun AegisApp() {
    var command by remember { mutableStateOf("") }
    var messages by remember {
        mutableStateOf(
            listOf(
                "AEGIS" to "Hello. AEGIS is ready."
            )
        )
    }

    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "AEGIS",
                style = MaterialTheme.typography.headlineLarge
            )

            Text(
                text = "Autonomous Executive & General Intelligence System",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(messages) { message ->
                    Card(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(12.dp)
                        ) {
                            Text(
                                text = message.first,
                                style = MaterialTheme.typography.labelLarge
                            )
                            Text(text = message.second)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = command,
                onValueChange = { command = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Ask AEGIS") },
                placeholder = {
                    Text("Ask a question or give a command")
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = {
                        if (command.isNotBlank()) {
                            messages = messages + ("You" to command)
                            messages = messages + (
                                "AEGIS" to
                                    "Command received. AI tools will be connected in the next build stage."
                                )
                            command = ""
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Send")
                }

                Button(
                    onClick = {
                        messages = messages + (
                            "AEGIS" to
                                "Voice assistant interface is ready for integration."
                            )
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Voice")
                }
            }
        }
    }
}
