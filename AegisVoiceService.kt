package com.aegis.mobile.voice

import android.app.*
import android.content.Intent
import android.os.IBinder

class AegisVoiceService : Service() {
    private val channelId = "aegis_voice"

    override fun onCreate() {
        super.onCreate()
        val manager = getSystemService(NotificationManager::class.java)
        manager.createNotificationChannel(
            NotificationChannel(
                channelId, "AEGIS Voice",
                NotificationManager.IMPORTANCE_LOW
            )
        )

        val notification = Notification.Builder(this, channelId)
            .setContentTitle("AEGIS voice mode")
            .setContentText("Voice assistant is active")
            .setSmallIcon(android.R.drawable.ic_btn_speak_now)
            .build()

        startForeground(1001, notification)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // TODO: connect a wake-word engine + SpeechRecognizer/streaming STT.
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? = null
}
