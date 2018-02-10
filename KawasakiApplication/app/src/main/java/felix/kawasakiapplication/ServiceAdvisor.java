package felix.kawasakiapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ServiceAdvisor extends AppCompatActivity {

    private EditText etAdvisorname,etAdvisorNumber;
    Button buttonOK,buttonCancel;
    SharedPreferences data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_advisor);

        data = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        etAdvisorname = (EditText)findViewById(R.id.etAdvisorname);
        etAdvisorNumber = (EditText)findViewById(R.id.etAdvisorcontact);
        buttonOK = (Button)findViewById(R.id.btnOK9);
        buttonCancel = (Button)findViewById(R.id.btnCancel9);

        loadSavedPreferences();

        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etAdvisorname.getText()) || TextUtils.isEmpty(etAdvisorNumber.getText())) {
                    Toast.makeText(getApplicationContext(), "Please enter all fields", Toast.LENGTH_SHORT).show();
                } else if (etAdvisorNumber.getText().length() < 10) {
                    Toast.makeText(ServiceAdvisor.this, "Please enter a valid mobile number", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(ServiceAdvisor.this, EditDetails.class);
                    data.edit().putString("AdvisorName", etAdvisorname.getText().toString()).apply();
                    data.edit().putString("AdvisorNumber", etAdvisorNumber.getText().toString()).apply();
                    startActivity(intent);
                    //  finish();
                }
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etAdvisorNumber.setText("");
                etAdvisorname.setText("");
            }
        });

    }

    private void loadSavedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);

        etAdvisorname.setText(sharedPreferences.getString("string_9_et1", ""));
        etAdvisorNumber.setText(sharedPreferences.getString("string_9_et2", ""));


    }

    private void savePreferences(String key, String value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void saveData(){
        savePreferences("string_9_et1", etAdvisorname.getText().toString());
        savePreferences("string_9_et2", etAdvisorNumber.getText().toString());

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        saveData();
    }
}
