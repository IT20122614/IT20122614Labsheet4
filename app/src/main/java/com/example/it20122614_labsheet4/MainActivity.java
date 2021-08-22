package com.example.it20122614_labsheet4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnStart;
    Button btnStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = (Button) this.findViewById(R.id.startBtn);
        btnStop= (Button) this.findViewById(R.id.stopBtn);

        MediaPlayer player = MediaPlayer.create(this, Settings.System.DEFAULT_NOTIFICATION_URI);
        player.setLooping(true);
        player.start();

        btnStart.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                startService(new Intent(MainActivity.this, MyServices.class));
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                stopService(new Intent(MainActivity.this, MyServices.class));
            }
        });


    }
}