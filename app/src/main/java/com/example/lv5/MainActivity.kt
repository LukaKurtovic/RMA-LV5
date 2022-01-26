package com.example.lv5

import android.media.AudioAttributes
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ib1 = findViewById<ImageButton>(R.id.ib1)
        val ib2 = findViewById<ImageButton>(R.id.ib2)
        val ib3 = findViewById<ImageButton>(R.id.ib3)
        val ib4 = findViewById<ImageButton>(R.id.ib4)

        val soundPool: SoundPool
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
           val audioAttributes = AudioAttributes.Builder()
                   .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                   .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                   .build()
            soundPool = SoundPool.Builder()
                    .setMaxStreams(4)
                    .setAudioAttributes(audioAttributes)
                    .build()
        }else{
            soundPool = SoundPool(4, AudioManager.STREAM_MUSIC, 0)
        }
        val kretenu = soundPool.load(applicationContext, R.raw.kretenu, 1)
        val neces = soundPool.load(applicationContext, R.raw.neces, 1)
        val provokator = soundPool.load(applicationContext, R.raw.provokator, 1)
        val rasturite = soundPool.load(applicationContext, R.raw.rasturite, 1)

        ib1.setOnClickListener {
            soundPool.play(kretenu, 1f,1f,1,0,1f)
        }
        ib2.setOnClickListener {
            soundPool.play(neces, 1f,1f,1,0,1f)
        }
        ib3.setOnClickListener {
            soundPool.play(provokator, 1f,1f,1,0,1f)
        }
        ib4.setOnClickListener {
            soundPool.play(rasturite, 1f,1f,1,0,1f)
        }
    }

}