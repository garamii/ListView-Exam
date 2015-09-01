
package com.example.android.listveiwexam;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
        // 누군가로부터 실행이 되었을떄

        mImageView = (ImageView) findViewById(R.id.image);
        mNameView = (TextView) findViewById(R.id.name);
        mPhoneNumTextView = (TextView) findViewById(R.id.phoneNumber);

        // 나를 호출한 Acitvity 에서 보낸 값

        if (getIntent() != null) {

            int imageRes = getIntent().getIntExtra("image", -1);
            String name = getIntent().getStringExtra("name");
            String phone = getIntent().getStringExtra("phone");

            mImageView.setImageResource(imageRes);
            mNameView.setText(name);
            mPhoneNumTextView.setText(phone);

        }
        // xml 안 쓰는 방법
        mPhoneNumTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Uri uri = Uri.parse("tel:" + mPhoneNumTextView.getText().toString());
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);

                startActivity(intent);
            }
        });

    }

    // xml에 onClick 속성 연결

    public void call(View view) {
        final Uri uri = Uri.parse("tel:" + mPhoneNumTextView.getText().toString());
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);
    }

}
