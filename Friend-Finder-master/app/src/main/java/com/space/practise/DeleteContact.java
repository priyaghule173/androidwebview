package com.space.practise;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Pranav on 18/09/2016.
 */
public class DeleteContact extends Activity {
    private EditText NametoDelete;
    private String deletename;
    private static final String tag = "deletedContact";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deletecontact);

    }

    public void deleteObject(View view) {
        NametoDelete = (EditText) findViewById(R.id.nametodelete);
        deletename = NametoDelete.getText().toString();
        FriendManager manager = FriendManager.getInstance();
        ArrayList<Friend> friends = manager.getFriends();

        for (int i = 0; i < friends.size(); i++) {
            if (deletename.equals(friends.get(i).getName())) {
                Toast.makeText(this, "yes deleted " + friends.get(i).getName(), Toast.LENGTH_SHORT).show();
                friends.remove(i);
            }
        }
        Log.d(tag, "Remaining Objects ");
        for (int i = 0; i < friends.size(); i++) {
            Log.d(tag, " " + friends.get(i).getName());

        }
    }

    public void gotohomeActivity(View view) {
        Intent goToHome = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(goToHome);
    }
}
