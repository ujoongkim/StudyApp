package com.kwj.mystudyapp;

import static com.kwj.mystudyapp.R.id.btnNew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Ex5DataActivity extends AppCompatActivity {

    public static String id, hp;
    EditText etId, etHp, etSendId, etSendHp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex5_data);
        //id연동
        etId = (EditText) findViewById(R.id.etId);
        etHp = (EditText) findViewById(R.id.etHp);
        etSendId = (EditText) findViewById(R.id.etSendId);
        etSendHp = (EditText) findViewById(R.id.etSendHp);

        findViewById(R.id.btnStatic1).setOnClickListener(mClickListener);
        findViewById(btnNew).setOnClickListener(mClickListener);
    }

    //버튼이벤트를 감지함...
    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnStatic1:
                    id = etId.getText().toString();
                    hp = etHp.getText().toString();

                    etId.setText("");
                    etHp.setText("");
                    Toast.makeText(Ex5DataActivity.this,"저장되었습니다.",Toast.LENGTH_SHORT).show();
                    break;

                case btnNew:
                    String getId = etSendId.getText().toString();
                    String getHp = etSendHp.getText().toString();

                    Intent intent1 = new Intent(Ex5DataActivity.this, Ex5NewActivity.class);
                    intent1.putExtra("id", getId);
                    intent1.putExtra("hp", getHp);
                    startActivity(intent1);
                    break;
            }
        }
    };
}