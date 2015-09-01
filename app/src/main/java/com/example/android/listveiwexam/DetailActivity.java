package com.example.android.listveiwexam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private ImageView mImageView;
    private TextView mNameView;
    private TextView mPhoneNumTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //누군가로부터 실행이 되었을떄


        mImageView = (ImageView)findViewById(R.id.image);
        mNameView = (TextView)findViewById(R.id.name);
        mPhoneNumTextView = (TextView)findViewById(R.id.phoneNumber);

        //나를 호출한 Acitvity 에서 보낸 값

            if (getIntent() !=null){
                int imageRes = getIntent().getIntExtra("image", -1);
                String name = getIntent().getStringExtra("name");
                String phone = getIntent().getStringExtra("phone");

            mImageView.setImageResource(imageRes);
            mNameView.setText(name);
            mPhoneNumTextView.setText(phone);


        }
    }


}
