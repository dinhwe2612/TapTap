package com.example.taptap.data;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class User {

    static int mCount = 0;
    String mNickname;
    String mDescription;
    int mId;

    public User(String nickname, String desciption) {
        mId = mCount++;
        this.mNickname = nickname;
        this.mDescription = desciption;
    }

    public String getNickname() {
        return mNickname;
    }

    public void setNickname(String nickname) {
        this.mNickname = nickname;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public int getId() {
        return mId;
    }

}
