package com.kwj.mystudyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Ex5NewActivity extends AppCompatActivity {
    EditText etInnerId, etInnerHp, etRcvId, etRcvHp;
    Button btnStatic2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex5_new);

        etInnerId = (EditText) findViewById(R.id.etInnerId);
        etInnerHp = (EditText) findViewById(R.id.etInnerHp);
        etRcvId = (EditText) findViewById(R.id.etRcvId);
        etRcvHp = (EditText) findViewById(R.id.etRcvHp);
        btnStatic2 = (Button) findViewById(R.id.btnStatic2);

        //전달받은 데이타 받기
        Intent getData = getIntent();
        String id = getData.getStringExtra("id");
        String hp = getData.getStringExtra("hp");
        etRcvId.setText(id);
        etRcvHp.setText(hp);

        btnStatic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etInnerId.setText(Ex5DataActivity.id);
                etInnerHp.setText(Ex5DataActivity.hp);
            }
        });
    }
}




