package com.space.practise;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Pranav on 18/09/2016.
 */
public class ListOfTags extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listoftagsactivity);
    }

    public void searchByTag(View view) {
        //TODO
        Intent tagintent = new Intent(this, AddTagActivity.class);
        startActivity(tagintent);
    }
}
