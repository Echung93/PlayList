package org.techtown.playlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MusicListActivity extends AppCompatActivity {
    private Button btn_Back1, btn_Add1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_list);

        btn_Back1 = (Button) findViewById(R.id.btn_Back1);
        btn_Add1 = (Button) findViewById(R.id.btn_Add1);

        btn_Back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = "title";
                // back_btn 눌렀을시 MainActivity 로
                Toast.makeText(getApplicationContext(), a, Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(MusicListActivity.this, PlayListActivity.class);
                startActivity(intent1);
            }
        });

        btn_Add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MusicListActivity.this, PlayListActivity.class);
                startActivity(intent1);
            }
        });
    }

    //초기 음악 리스트 만들기
//        public void InitializeMusicData()
//        {
//            musicListItems = new ArrayList<MusicListItem>();
//
//            musicListItems.add(new MusicListItem(R.drawable.cover, "아로하"));
//            musicListItems.add(new MusicListItem(R.drawable.cover, "겨울잠"));
//            musicListItems.add(new MusicListItem(R.drawable.cover, "신호"));
//            musicListItems.add(new MusicListItem(R.drawable.cover, "사랑은 늘 도망가"));
//            musicListItems.add(new MusicListItem(R.drawable.cover, "오래된 노"));
//        }
}