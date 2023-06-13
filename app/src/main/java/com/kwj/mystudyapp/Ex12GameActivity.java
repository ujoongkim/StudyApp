package com.kwj.mystudyapp;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Ex12GameActivity extends AppCompatActivity {
    TextView tvChance,tvResult,tvTot,tvGoal,tvFail;
    ImageView ivMain;

    int goalCnt, failCnt,totCnt;
    int chanceCnt=10;

    Animation ani1,ani2;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex12_game);
        ivMain = (ImageView) findViewById(R.id.ivMain);
        tvResult = (TextView) findViewById(R.id.tvResult);
        tvChance = (TextView) findViewById(R.id.tvChance);
        tvTot = (TextView) findViewById(R.id.tvTot);
        tvGoal = (TextView) findViewById(R.id.tvGoal);
        tvFail = (TextView) findViewById(R.id.tvFail);

        findViewById(R.id.btnPlay1).setOnClickListener(mClickListener);
        findViewById(R.id.btnPlay2).setOnClickListener(mClickListener);
        findViewById(R.id.btnPlay3).setOnClickListener(mClickListener);
        findViewById(R.id.btnReset).setOnClickListener(mClickListener);

        ani1 = AnimationUtils.loadAnimation(Ex12GameActivity.this, R.anim.set_goal);
        ani2 = AnimationUtils.loadAnimation(Ex12GameActivity.this, R.anim.scale2);

        Glide.with(Ex12GameActivity.this).load(R.drawable.move).into(ivMain);
    }

    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {

            switch(v.getId())
            {
                case R.id.btnPlay1:
                    int comRand = (int)(Math.random()*100+1);
                    Glide.with(Ex12GameActivity.this).load(R.drawable.longkick).into(ivMain);
                    if(comRand<51 && chanceCnt>1) {
                        tvResult.setText(" 중거리 슛 성공! "); goalCnt++; chanceCnt-=2;}


                        else if (comRand>50 && chanceCnt>1) {tvResult.setText(" 중거리 슛 실패! "); failCnt++; chanceCnt-=2;
                            Glide.with(Ex12GameActivity.this).load(R.drawable.fail).into(ivMain);}
                    break;

                case R.id.btnPlay2:
                    comRand = (int)(Math.random()*90+1);
                    Glide.with(Ex12GameActivity.this).load(R.drawable.penalty).into(ivMain);
                    if(comRand<46 && chanceCnt>2) {tvResult.setText(" 페널티 슛 성공! "); goalCnt++; chanceCnt-=3;}


                        else if (comRand>45 && chanceCnt>2) {tvResult.setText(" 페널티 슛 실패! "); failCnt++; chanceCnt-=3;
                            Glide.with(Ex12GameActivity.this).load(R.drawable.fail).into(ivMain);}
                    break;


                case R.id.btnPlay3:
                    comRand = (int)(Math.random()*30+1);
                    Glide.with(Ex12GameActivity.this).load(R.drawable.heading).into(ivMain);
                    if(comRand<31 && chanceCnt>0) {tvResult.setText(" 헤딩 슛 성공! "); goalCnt++; chanceCnt--;}


                        else if (comRand>30 && chanceCnt>0) {tvResult.setText(" 헤딩 슛 실패! ");  failCnt++; chanceCnt--;
                            Glide.with(Ex12GameActivity.this).load(R.drawable.fail).into(ivMain);}
                    break;

                case R.id.btnReset:
                    Glide.with(Ex12GameActivity.this).load(R.drawable.gamestart).into(ivMain);
                    goalCnt=0; failCnt=0; chanceCnt=10; tvResult.setText("대기중...");

                    break;

            }
            totCnt=goalCnt+failCnt;

            tvGoal.setText("골 :"+goalCnt+"회");
            tvFail.setText("실패 :"+failCnt+"회");
            tvTot.setText("전적 : 총 "+totCnt+"회");
            tvChance.setText("슛 기회 :"+chanceCnt+"회");

            if(chanceCnt==0) {Toast.makeText(Ex12GameActivity.this, "게임 기회 끝!", Toast.LENGTH_SHORT).show();
                Glide.with(Ex12GameActivity.this).load(R.drawable.gameover).into(ivMain);}
        }
    };
}