package com.example.taptap.data;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    List<User> mUsers;
    List<Content> mContents;

    static Repository repository;

    private Repository() {
        mUsers = new ArrayList<User>();
        mContents = new ArrayList<Content>();
    }

    static public Repository getInstance() {
        if (repository == null) {
            repository = new Repository();
        }
        return repository;
    }
    public void addUser(User user) {
        mUsers.add(user);
    }
    public void addContent(Content content) {
        mContents.add(content);
    }

    public User getUserById(int userId) {
        return mUsers.get(userId);
    }

    public Content getContentById(int contentId) {
        return mContents.get(contentId);
    }

    public int getContentSize() {
        return mContents.size();
    }

    public int getUserSize() {
        return mUsers.size();
    }
}
