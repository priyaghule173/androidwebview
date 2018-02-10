package felix.kawasakiapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DriverDetails extends AppCompatActivity {

    private TextView textSign;
    private EditText editSign,editDrivername,editDrivernumber,editDriverlicense;
    Button buttonOK,buttonCancel;
    SharedPreferences data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_details);


        data = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        textSign = (TextView)findViewById(R.id.txtSign);
        editSign = (EditText)findViewById(R.id.etSign);
        editDrivername = (EditText)findViewById(R.id.input_drivername);
        editDrivernumber = (EditText)findViewById(R.id.input_drivercontact);
        editDriverlicense = (EditText)findViewById(R.id.input_driverlicense);
        buttonOK = (Button)findViewById(R.id.btnok6);
        buttonCancel = (Button)findViewById(R.id.btncncl6);

        loadSavedPreferences();

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editDrivername.setText("");
                editDrivernumber.setText("");
                editDriverlicense.setText("");
                editSign.setText("");
            }
        });

        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(editDrivername.getText()) || TextUtils.isEmpty(editDrivernumber.getText())
                        || TextUtils.isEmpty(editDriverlicense.getText())|| TextUtils.isEmpty(editSign.getText())){

                    Toast.makeText(getApplicationContext(), "Please enter all fields", Toast.LENGTH_SHORT).show();

                }
                else if(editDrivernumber.getText().length() < 10){
                    Toast.makeText(DriverDetails.this,"Please enter a valid mobile number",Toast.LENGTH_SHORT).show();
                }
                else {

                    data.edit().putString("DriverName", String.valueOf(editDrivername.getText())).apply();
                    data.edit().putString("DriverNumber", String.valueOf(editDrivernumber.getText())).apply();
                    data.edit().putString("DriverLicense", String.valueOf(editDriverlicense.getText())).apply();
                    Intent intent = new Intent(DriverDetails.this,FuelGauge.class);
                    startActivity(intent);
                    //  finish();
                }
            }
        });

        String checkSign = String.valueOf(editSign.getText());
        if(checkSign.equals("Siganture done")){
            buttonOK.setVisibility(View.VISIBLE);
        }
        textSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DriverDetails.this, SignatureMain.class);
                startActivityForResult(intent, 1);
            }
        });

        // SharedPreferences data = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        // String signName = data.getString("Sign", "THIS IS DEFAULT VALUE");

        // editSign.setText(signName);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 1:
                if(resultCode == Activity.RESULT_OK){
                    String newText = data.getStringExtra("Text");
                    editSign.setText(newText);
                }
        }
    }

    private void loadSavedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);

        editDrivername.setText(sharedPreferences.getString("string_6_et1", ""));
        editDrivernumber.setText(sharedPreferences.getString("string_6_et2", ""));
        editDriverlicense.setText(sharedPreferences.getString("string_6_et3", ""));
        editSign.setText(sharedPreferences.getString("string_6_et4", ""));

    }

    private void savePreferences(String key, String value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void saveData(){
        savePreferences("string_6_et1", editDrivername.getText().toString());
        savePreferences("string_6_et2", editDrivernumber.getText().toString());
        savePreferences("string_6_et3", editDriverlicense.getText().toString());
        savePreferences("string_6_et4", editSign.getText().toString());


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        saveData();
    }
}
