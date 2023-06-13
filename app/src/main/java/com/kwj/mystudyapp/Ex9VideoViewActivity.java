package com.kwj.mystudyapp;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;


public class Ex9VideoViewActivity extends AppCompatActivity {

    VideoView vv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex9_videoview);
        vv = (VideoView)findViewById(R.id.videoView);

        findViewById(R.id.btnPlay).setOnClickListener(mClick);
        findViewById(R.id.btnPause).setOnClickListener(mClick);
        findViewById(R.id.btnStop).setOnClickListener(mClick);
        Uri videoUri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.pado);
        vv.setMediaController(new MediaController(this));
        vv.setVideoURI(videoUri);
    }
    View.OnClickListener mClick = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            switch(v.getId())
            {
                case R.id.btnPlay:
                    vv.start();
                    break;
                case R.id.btnPause:
                    vv.pause();
                    break;
                case R.id.btnStop:
                    vv.stopPlayback();
                    break;

            }

        }
    };


}