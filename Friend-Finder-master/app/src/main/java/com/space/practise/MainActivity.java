package com.space.practise;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
    LinearLayout backgroundcolor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addContact(View view) {
        Intent addDetailIntent = new Intent(getApplicationContext(), AddContact.class);
        startActivity(addDetailIntent);
    }

    public void addTag(View view) {
        //TODO
        Intent tagintent = new Intent(this, AddTagActivity.class);
        startActivity(tagintent);
    }

    public void addEvent(View view) {
        //TODO
    }
}
