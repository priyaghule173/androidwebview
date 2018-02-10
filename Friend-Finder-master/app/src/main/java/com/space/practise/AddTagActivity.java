package com.space.practise;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Pranav on 11/09/2016.
 */
public class AddTagActivity extends Activity {
    private final static String tag = "tafg";
    public Button sendMessage, callUser;
    public String tagstring = "", Smsusersno;
    public Spinner searchTag;
    FriendManager manager = FriendManager.getInstance();
    ArrayList<Friend> friends = manager.getFriends();
    private TextView textViewName, textViewNameother, textViewPhoneno;
    private Intent sendMessageIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addtagactivity);
        sendMessage = (Button) findViewById(R.id.sendButtonid);
        callUser = (Button) findViewById(R.id.calluserid);
        textViewName = (TextView) findViewById(R.id.nameofsimilartag);
        sendMessage.setVisibility(View.INVISIBLE);
        callUser.setVisibility(View.INVISIBLE);
    }

    public void addTagtoString(View view) {
        searchTag = (Spinner) findViewById(R.id.Tagdisplay);
        tagstring = searchTag.getSelectedItem().toString();
        sendMessageIntent = new Intent(getApplicationContext(), SendMessage.class);

        callUser.setVisibility(View.VISIBLE);
        sendMessage.setVisibility(View.VISIBLE);
        for (int i = 0, j = 0; i < friends.size(); i++) {
            if (tagstring.equals(friends.get(i).getTag())) {

                Smsusersno = friends.get(i).getNumber();
                Toast.makeText(this, " Tag Found " + friends.get(i).getName() + " " + tagstring, Toast.LENGTH_SHORT).show();
                textViewName.setText("" + friends.get(i).getName());
                sendMessageIntent.putExtra("sametagusers", friends.get(i).getName());

            } else {
                Log.d(tag, "No match found for i = " + i);
            }
        }
    }


    public void sendMessage(View view)
    {
        Intent sendMessageintent = new Intent();
        sendMessageintent.setAction(Intent.ACTION_VIEW);
//        for (int i = 0; i < Smsusersno.length; i++) {
        sendMessageintent.setData(Uri.parse("smsto:" + Smsusersno));
        //      }

        if (sendMessageintent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(sendMessageintent);
        } else
        {
            Toast.makeText(this, "No application found ", Toast.LENGTH_SHORT).show();
        }
    }


    public void callUser(View view) {


        Intent CallUserIntent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+Smsusersno));

        if (CallUserIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(CallUserIntent);
        } else {
            Toast.makeText(this, "No application ", Toast.LENGTH_SHORT).show();
        }
    }
}
