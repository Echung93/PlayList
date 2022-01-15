package org.techtown.playlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlayListActivity extends AppCompatActivity {
    private TextView textView;
    private Button btn_Back, btn_Add;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list);

        Intent intent = getIntent();
        String title = intent.getStringExtra("name");

        textView = (TextView) findViewById(R.id.title);
        btn_Back = (Button) findViewById(R.id.btn_Back);
        btn_Add = (Button) findViewById(R.id.btn_Add);
        textView.setText(title + " 노래 목록 ");

        btn_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back_btn 눌렀을시 MainActivity 로
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MusicListActivity.class);
                startActivity(intent);
            }
        });

    }
}