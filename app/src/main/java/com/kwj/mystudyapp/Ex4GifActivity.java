package com.kwj.mystudyapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Ex4GifActivity extends AppCompatActivity {
    ImageView ivMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex4_gif);
        ivMain = (ImageView) findViewById(R.id.ivMain);

        findViewById(R.id.btnG1).setOnClickListener(mClickListener);
        findViewById(R.id.btnG2).setOnClickListener(mClickListener);
        findViewById(R.id.btnG3).setOnClickListener(mClickListener);
    }
    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch(v.getId())
            {
                case R.id.btnG1:
                    Glide.with(Ex4GifActivity.this).load(R.drawable.img1).into(ivMain);
                    break;
                case R.id.btnG2:
                    Glide.with(Ex4GifActivity.this).load(R.drawable.img2).into(ivMain);
                    break;
                case R.id.btnG3:
                    Glide.with(Ex4GifActivity.this).load(R.drawable.img3).into(ivMain);
                    break;

            }
        }
    };

}
