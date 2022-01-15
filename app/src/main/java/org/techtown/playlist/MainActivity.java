package org.techtown.playlist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SingerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        // 어댑터 안에 데이터 담기
        adapter = new SingerAdapter();

        adapter.addItem(new PlayListItem("밤편지", R.drawable.cover));

        // 리스트 뷰에 어댑터 설정
        listView.setAdapter(adapter);

        // 이벤트 처리 리스너 설정
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PlayListItem item = (PlayListItem) adapter.getItem(position);
                String a = item.getName();
                Toast.makeText(getApplicationContext(), "선택 :"+ a, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), PlayListActivity.class);
                intent.putExtra("name",a);
                startActivity(intent);
            }
        });

        // 버튼 눌렀을 때 우측 이름, 사진이 리스트뷰에 포함되도록 처리
        Button button = (Button) findViewById(R.id.btn_dialog);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
                ad.setIcon(R.mipmap.ic_launcher);
                ad.setTitle("플레이리스트");
                ad.setMessage("플레이리스트 제목을 입력바랍니다.");

                final EditText et = new EditText(MainActivity.this);
                ad.setView(et);

                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String result = et.getText().toString();
                        adapter.addItem(new PlayListItem(result, R.drawable.cover));
                        //리스트 갱신
                        adapter.notifyDataSetChanged();
                    }
                });

                ad.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                ad.show();
            }
        });
    }


    class SingerAdapter extends BaseAdapter {
        ArrayList<PlayListItem> items = new ArrayList<PlayListItem>();


        // Generate > implement methods
        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(PlayListItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // 뷰 객체 재사용
            PlayListItemView view = null;
            if (convertView == null) {
                view = new PlayListItemView(getApplicationContext());
            } else {
                view = (PlayListItemView) convertView;
            }

            PlayListItem item = items.get(position);

            view.setName(item.getName());
            view.setImage(item.getResId());

            return view;
        }
    }
}
