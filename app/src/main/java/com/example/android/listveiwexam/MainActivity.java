
package com.example.android.listveiwexam;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * 리스트뷰 연습
 */

public class MainActivity extends AppCompatActivity {
    private List<People> mData;
    private CustomAdapter mAdapter;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 1.data 준비
        initData();
        // 2. adpter준비
        initAdapter();

        // 3. ListView에 adpter 를 장착
        initListView();
    }

    private void initListView() {
        mListView = (ListView) findViewById(R.id.listView);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Positon : " +position, Toast.LENGTH_SHORT).show();

                final Uri uri = Uri.parse(mData.get(position).getPhoneNumber());
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);

                startActivity(intent);

            }
        });
    }

    private void initAdapter() {
        mAdapter = new CustomAdapter(getApplicationContext(),mData);
    }

    private void initData() {
        mData = new ArrayList<>();

        mData.add(new People(R.drawable.snowtree,"눈나무","010-1111-1111"));
        mData.add(new People(R.drawable.as,"호수","010-1111-1121"));

        for (int i = 1; i <= 100; i++) {
            mData.add(new People(R.mipmap.ic_launcher,"아무개","번호없음"));
        }

    }

}
