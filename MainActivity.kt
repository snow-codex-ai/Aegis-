package com.aegis.mobile

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.aegis.mobile.voice.AegisVoiceService

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { AegisHome() }
    }

    @Composable
    fun AegisHome() {
        var prompt by remember { mutableStateOf("") }
        val bg = Brush.verticalGradient(
            listOf(Color(0xFF050711), Color(0xFF0B1022), Color(0xFF080A16))
        )

        MaterialTheme(colorScheme = darkColorScheme()) {
            Box(
                Modifier.fillMaxSize().background(bg).padding(18.dp)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                    Text("AEGIS", style = MaterialTheme.typography.headlineLarge)
                    Text("Autonomous Executive & General Intelligence System",
                        color = Color.LightGray)

                    Card(
                        shape = RoundedCornerShape(28.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White.copy(alpha = .08f)
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(Modifier.padding(18.dp)) {
                            Text("What should I do?", style = MaterialTheme.typography.titleMedium)
                            Spacer(Modifier.height(10.dp))
                            OutlinedTextField(
                                value = prompt,
                                onValueChange = { prompt = it },
                                modifier = Modifier.fillMaxWidth(),
                                placeholder = { Text("Ask, create, calculate, search…") }
                            )
                            Spacer(Modifier.height(10.dp))
                            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                Button(onClick = { /* Send to AI orchestrator */ }) {
                                    Text("Run")
                                }
                                OutlinedButton(onClick = {
                                    startForegroundService(
                                        Intent(this@MainActivity, AegisVoiceService::class.java)
                                    )
                                }) { Text("Voice") }
                            }
                        }
                    }

                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        GlassTile("Math & Physics", "Solver")
                        GlassTile("Code", "Engineer")
                    }
                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        GlassTile("Files", "PDF • JPG • MP4 • MP3")
                        GlassTile("Markets", "Analysis")
                    }

                    Text("System tools", style = MaterialTheme.typography.titleLarge)
                    Text(
                        "Device actions are permission-gated by Android. AEGIS should request only the permissions needed for each action.",
                        color = Color.Gray
                    )
                }
            }
        }
    }

    @Composable
    fun RowScope.GlassTile(title: String, subtitle: String) {
        Card(
            modifier = Modifier.weight(1f),
            shape = RoundedCornerShape(22.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White.copy(alpha = .07f)
            )
        ) {
            Column(Modifier.padding(14.dp)) {
                Text(title, style = MaterialTheme.typography.titleMedium)
                Text(subtitle, color = Color.Gray)
            }
        }
    }
}
