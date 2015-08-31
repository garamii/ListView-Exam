
package com.example.android.listveiwexam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by student on 2015-08-31. People 데이터 를 다루는
 */

public class CustomAdapter extends BaseAdapter {

    private List<People> mData;
    private Context mConText;
    private LayoutInflater inflater;

    public CustomAdapter(Context context, List<People> mData) {
        mConText = context;
        this.mData = mData;
        inflater = LayoutInflater.from(context);
    }

    // 데이터의 갯수
    @Override
    public int getCount() {
        return mData.size();
    }

    // Position 번째의 item
    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    // 각 item 의 id
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * @param position 포지션
     * @param convertView 포지션의 View
     * @param parent ㅎㅎㅎㅎ
     * @returngg ㅎㅎㅎ
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        // 1. 레이아웃 구성

        // convertView 처음 로딩 될 때 초기화 과정을 거쳐서 viewHolder에 저장
        if (convertView == null) {
            convertView = inflater.from(mConText).inflate(R.layout.item_people, parent, false);

            // 각 view 를 소스로 연결
            ImageView image = (ImageView) convertView.findViewById(R.id.imageId);
            TextView name = (TextView) convertView.findViewById(R.id.name);
            TextView phoneNumber = (TextView) convertView.findViewById(R.id.phoneNumber);

            // viewHolder 를 생성후 , 가져온 view 를 연결

            viewHolder = new ViewHolder();
            viewHolder.image = image;
            viewHolder.name = name;
            viewHolder.phone = phoneNumber;

            // viewHolder 를 convertView 의 태그로저장
            convertView.setTag(viewHolder);
        } else {
            // convertView 가 다시 로딩 될때에는 viewHolder에서 꺼내와서 재사용
            // 이점 : 속도가 빠르다

            viewHolder = (ViewHolder) convertView.getTag();
        }
        // 2. 레이아웃에 데이터 를 바인딩

      //  People people = (People)getItem(positipon);
        People people = (People)getItem(position);
        viewHolder.image.setImageResource(people.getImageResourceId());
        viewHolder.name.setText(people.getName());
        viewHolder.phone.setText(people.getPhoneNumber());
        // 3. 완성된 View 를 리턴

        return convertView;
    }

    static class ViewHolder {
        ImageView image;
        TextView name;
        TextView phone;
    }
}
