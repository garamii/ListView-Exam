package com.example.android.listveiwexam;

/**
 * Created by student on 2015-08-31.
 * ㅎㅎ
 */
public class People {
    private String name;
    private String phoneNumber;

    public People(String name, String phoneNumber, int imageResourceId) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.imageResourceId = imageResourceId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    private int imageResourceId;

}
