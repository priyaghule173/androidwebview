package com.space.practise;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Pranav on 04/09/2016.
 */
public class FriendManager {
    private static int index = 0;
    public static final String tag = "came";
    private static FriendManager FriendManagerObject = null;
    public ArrayList<Friend> friends = new ArrayList<>();
    ;

    private FriendManager() {
    }

    public static synchronized FriendManager getInstance() {
        if (FriendManagerObject == null) {
            FriendManagerObject = new FriendManager();

        }
        return FriendManagerObject;
    }

    public ArrayList<Friend> getFriends() {
        return friends;
    }

    public boolean addFriend(Friend friend) {
        friends.add(index++, friend);
        return true;
    }

    public boolean getObjectsdetails() {
        for (int i = 0; i < friends.size(); i++) {
            Log.d(tag, friends.get(i).getName());
        }

        return true;
    }

    public boolean removeFriend(String name) {
        //// TODO: 04/09/2016
        return false;
    }
}
