package com.space.practise;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Pranav on 03/09/2016.
 */
public class DisplayDetails extends Activity {
    private EditText display;
    private static final String tag = "DisplayDetail";
    Friend friend;
    private TextView textViewName, textViewPhoneno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displaydetails);
        FriendManager obj = FriendManager.getInstance();
        ArrayList<Friend> friends = obj.getFriends();
        Log.d(tag, "" + friends.size());
        if (friends != null) {
            for (int i = 0; i < friends.size(); i++) {
                Log.d(tag, i + "th Object -> Name:" + friends.get(i).getName() + "  Phone No:" + friends.get(i).getNumber() + "  Tag:" + friends.get(i).getTag());
                //     textViewName.setText(friends.get(i).getName());
            }
        }
    }

    public void homeactivity(View view) {
        Intent gohomeintent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(gohomeintent);
    }

    public void deleteSingleContact(View view) {
        Intent deletesinglecontact = new Intent(getApplicationContext(), DeleteContact.class);
        startActivity(deletesinglecontact);
    }
}