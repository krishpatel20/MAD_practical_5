package com.example.practical_5

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class Myservise: Service() {
    companion object{
        val PlayPause="play/pause"
        val Service1="Service"
    }
    private lateinit var mediaPlayer: MediaPlayer
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (!this::mediaPlayer.isInitialized){
            mediaPlayer=MediaPlayer.create(this,R.raw.song)
        }
        if (intent!=null){
            val str1=intent.getStringExtra(Service1)
            if (str1==PlayPause){
                if (mediaPlayer.isPlaying){
                    mediaPlayer.pause()
                }
                else{
                    mediaPlayer.start()
                }
            }
        }
        else{
            mediaPlayer.start()
        }
        return START_STICKY
    }
    override fun onDestroy() {
        mediaPlayer.stop()
        super.onDestroy()
    }
}