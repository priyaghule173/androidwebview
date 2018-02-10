package felix.kawasakiapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RequestScreen extends AppCompatActivity {

    private TextView textView;
    Button buttonOK,buttonCancel;
    EditText etfirstRequest,etSecondRequest,etThirdRequest;

    SharedPreferences data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_screen);

        data = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        textView = (TextView)findViewById(R.id.txtRequest);
        buttonOK = (Button)findViewById(R.id.btnOK5);
        buttonCancel = (Button)findViewById(R.id.btnCancel5);
        etfirstRequest = (EditText)findViewById(R.id.firstRequest);
        etSecondRequest = (EditText)findViewById(R.id.secondRequest);
        etThirdRequest = (EditText)findViewById(R.id.thirdRequest);

        loadSavedPreferences();

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etfirstRequest.setText("");
                etSecondRequest.setText("");
                etThirdRequest.setText("");
            }
        });

        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RequestScreen.this,DriverDetails.class);
                data.edit().putString("UserRequest1", String.valueOf(etfirstRequest.getText())).apply();
                data.edit().putString("UserRequest2", String.valueOf(etSecondRequest.getText())).apply();
                data.edit().putString("UserRequest3", String.valueOf(etThirdRequest.getText())).apply();
                startActivity(intent);
            }
        });
    }

    private void loadSavedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);

        etfirstRequest.setText(sharedPreferences.getString("et_5_1", ""));
        etSecondRequest.setText(sharedPreferences.getString("et_5_2", ""));
        etThirdRequest.setText(sharedPreferences.getString("et_5_3", ""));

    }

    private void savePreferences(String key, String value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void saveData(){
        savePreferences("et_5_1", etfirstRequest.getText().toString());
        savePreferences("et_5_2", etSecondRequest.getText().toString());
        savePreferences("et_5_3", etThirdRequest.getText().toString());

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        saveData();
    }
}
