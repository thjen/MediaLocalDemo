package com.example.qthjen.medialocaldemo;

import android.media.MediaPlayer;
import android.media.session.MediaController;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    Button bt,bt1;

    VideoView vv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt = (Button) findViewById(R.id.bt);
        bt1 = (Button) findViewById(R.id.bt1);
        vv = (VideoView) findViewById(R.id.vv);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.anhmo);
                mediaPlayer.start();
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                vv.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.summer));
                vv.start();

                android.widget.MediaController mediaController = new android.widget.MediaController(MainActivity.this);
                mediaController.setMediaPlayer(vv);
                vv.setMediaController(mediaController);
            }
        });

    }

}
