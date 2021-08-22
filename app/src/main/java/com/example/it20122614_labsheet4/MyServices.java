package com.example.it20122614_labsheet4;


import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

public abstract class MyServices extends Service {
    private MediaPlayer player;
    public int onStartcommand(Intent intent, int flags, int startId){
        player = MediaPlayer.create(this, Settings.System.DEFAULT_NOTIFICATION_URI);
        player.setLooping(true);
        player.start();

        return START_STICKY;
    }
    public void onDestroy(){
        super.onDestroy();
        player.stop();
    }




}
