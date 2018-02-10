package com.space.practise;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Pranav on 20/09/2016.
 */
public class SendMessage extends Activity {
    private TextView displaysameuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sendmessage);
        displaysameuser = (TextView) findViewById(R.id.sameuser);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String userofsametag = bundle.getString("sametagusers").toString();
            displaysameuser.setText(userofsametag);
        }
    }
}
