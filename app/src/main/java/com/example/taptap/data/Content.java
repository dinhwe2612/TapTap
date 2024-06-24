package com.example.taptap.data;

import java.io.File;
import java.util.List;

public class Content {
    static int mCount = 0;
    int mId = 0; // Unique identifier for the content
    String mDescription = null; // A short description or caption for the content
    int mLikesCount = 0; // Number of likes the content has received
    List<String> mTags = null; // Tags associated with the content for discovery
    User mContentOwner = null;

    File mImagePath = null;

    private Content() {

    }

    public Content(User user) {
        mId = mCount++;
        mContentOwner = user;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public int getLikesCount() {
        return mLikesCount;
    }

    public void setLikesCount(int mLikesCount) {
        this.mLikesCount = mLikesCount;
    }

    public List<String> getTags() {
        return mTags;
    }

    public void setTags(List<String> mTags) {
        this.mTags = mTags;
    }

    public User getContentOwner() {
        return mContentOwner;
    }

    public void increaseLikesCount() {
        ++mLikesCount;
    }

    public void decreaseLikesCount() {
        --mLikesCount;
    }

    public void setImagePath(File mImagePath) {
        this.mImagePath = mImagePath;
    }
}