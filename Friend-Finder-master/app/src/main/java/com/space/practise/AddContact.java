package com.space.practise;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Pranav on 03/09/2016.
 */
public class AddContact extends Activity {
    // EditText tagvalue;

    private String PhoneNo = null, namestr = null, Tag = null;
    private static final int RESULT_PICK_CONTACT = 85500;
    private TextView textViewName, textViewPhoneno;
    private EditText name, number;
    private Spinner tagSpinner;
    public static final String tag = "tagg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcontact);
        textViewName = (TextView) findViewById(R.id.namedisplay);
        textViewPhoneno = (TextView) findViewById(R.id.numberdisplay);
        tagSpinner = (Spinner) findViewById(R.id.Tagdisplay);
    }

    public void displaySavedContacts(View view) {

        FriendManager obj = FriendManager.getInstance();
        Intent adddetailsintent = new Intent(getApplicationContext(), DisplayDetails.class);
        startActivity(adddetailsintent);

        ArrayList<Friend> friends = obj.getFriends();
        if (friends != null) {
            textViewName.setText(friends.get(0).getName() + friends.get(0).getNumber());
        }
    }


    public void save(View view) {
        FriendManager obj = FriendManager.getInstance();

        //       String username = name.getText().toString();
        //     String usernumber = number.getText().toString();

        String tagspinner = tagSpinner.getSelectedItem().toString();
        Friend friendsingle;
        if (namestr != null && PhoneNo != null && tagspinner != null) {
            friendsingle = new Friend(namestr, PhoneNo, tagspinner);
            if (obj.addFriend(friendsingle) == true) {
                textViewName.setText(namestr + " " + PhoneNo);
                Toast.makeText(this, "Contact is Saved", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "please select valid Contact", Toast.LENGTH_SHORT).show();
        }
    }


    public void pickContact(View view) {
        Intent contactPickerintent = new Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
        startActivityForResult(contactPickerintent, RESULT_PICK_CONTACT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {

            switch (requestCode) {
                case RESULT_PICK_CONTACT:
                    contactPicked(data);
                    break;
            }
        } else {
            Log.e("MainActivity", "Failed to pick Contact");
        }

    }


    private void contactPicked(Intent data) {
        Cursor cursor = null;

        try {
            Uri uri = data.getData();
            cursor = getContentResolver().query(uri, null, null, null, null);

            cursor.moveToFirst();

            int phoneIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            int nameIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);

            PhoneNo = cursor.getString(phoneIndex);
            namestr = cursor.getString(nameIndex);
            textViewPhoneno.setText(namestr + " " + PhoneNo);

            //   Toast.makeText(this, namestr + " " + PhoneNo, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
