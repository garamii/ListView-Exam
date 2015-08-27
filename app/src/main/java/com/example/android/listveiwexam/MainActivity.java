
package com.example.android.listveiwexam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> mData;
    private ArrayAdapter<String> mAdapter;
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
        mListView =(ListView) findViewById(R.id.listView);
        mListView.setAdapter(mAdapter);
    }

    private void initAdapter() {
        mAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                mData);
    }

    private void initData() {
        mData = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            mData.add("item" + i);
        }

    }

}
