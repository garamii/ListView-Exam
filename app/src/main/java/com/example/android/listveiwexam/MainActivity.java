
package com.example.android.listveiwexam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

/**
 * 리스트뷰 연습1
 */

public class MainActivity extends AppCompatActivity {
    private List<People> mData;
    private CustomAdapter mAdapter;
    private GridView mListView;

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
        mListView = (GridView) findViewById(R.id.listView);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //아이템이 클릭 되었 을 떄 동작 하는 부분
//                Toast.makeText(MainActivity.this, "Positon : " +position, Toast.LENGTH_SHORT).show();

//              전화걸기

                //암시적 인텐트 Expicite intent
//                final Uri uri = Uri.parse(mData.get(position).getPhoneNumber());
 //               mData.get(position).getPhoneNumber();
//                Intent intent = new Intent(Intent.ACTION_DIAL, uri);

                // 화면이동
                //명시적 인텐트 implicit intent

                Intent intent = new Intent(getApplicationContext(),DetailActivity.class);

                People people = mData.get(position);

                intent.putExtra("image", people.getImageResourceId());
                intent.putExtra("name", people.getName());
                intent.putExtra("phone", people.getPhoneNumber());



                startActivity(intent);

            }
        });
    }

    private void initAdapter() {
        mAdapter = new CustomAdapter(getApplicationContext(),mData);
    }

    private void initData() {
        mData = new ArrayList<>();

        mData.add(new People(R.drawable.snowtree, "눈나무", "010-1111-1111"));
        mData.add(new People(R.drawable.as, "호수", "010-1111-1121"));

        for (int i = 1; i <= 100; i++) {
            mData.add(new People(R.mipmap.ic_launcher, "아무개", "번호없음"));
        }

    }

}
