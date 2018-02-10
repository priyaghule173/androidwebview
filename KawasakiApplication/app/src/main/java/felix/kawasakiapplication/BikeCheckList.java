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

public class BikeCheckList extends AppCompatActivity {

    private Button buttonOK,buttonCancel;
    private Button buttonManualyes,buttonGraphicsyes,buttonIndicatoryes,buttonToolkityes,buttonSeatyes;
    private Button buttonManualno,buttonGraphicsno,buttonIndicatorno,buttonToolkitno,buttonSeatno;

    private EditText etKeys,etBatterymake,etTyremake;
    private EditText editManual,editGraphics,editIndicator,editToolkit,editSeatcover;
    SharedPreferences data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike_check_list);

        data = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        buttonManualyes = (Button)findViewById(R.id.btnwarrantyyes);
        buttonGraphicsyes = (Button)findViewById(R.id.btngraphicsyes);
        buttonIndicatoryes = (Button)findViewById(R.id.btnindicatoryes);
        buttonToolkityes = (Button)findViewById(R.id.btntoolkityes);
        buttonSeatyes = (Button)findViewById(R.id.btnseatyes);

        buttonManualno = (Button)findViewById(R.id.btnwarrantyno);
        buttonGraphicsno = (Button)findViewById(R.id.btngraphicsno);
        buttonIndicatorno = (Button)findViewById(R.id.btnindicatorno);
        buttonToolkitno = (Button)findViewById(R.id.btntoolkitno);
        buttonSeatno = (Button)findViewById(R.id.btnseatno);


        editManual = (EditText)findViewById(R.id.etwarranty);
        editGraphics = (EditText)findViewById(R.id.etbikegraphics);
        editIndicator = (EditText)findViewById(R.id.etIndicator);
        editToolkit = (EditText)findViewById(R.id.etToolkit);
        editSeatcover = (EditText)findViewById(R.id.etSeatcover);

        etKeys = (EditText)findViewById(R.id.etNoofkeys);
        etBatterymake = (EditText)findViewById(R.id.etBatteryMake);
        etTyremake = (EditText)findViewById(R.id.etTyreMake);

        loadSavedPreferences();

        buttonOK = (Button) findViewById(R.id.btnOK8);

        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(editManual.getText()) || TextUtils.isEmpty(editGraphics.getText())
                        || TextUtils.isEmpty(editIndicator.getText())
                        || TextUtils.isEmpty(editToolkit.getText()) || TextUtils.isEmpty(editSeatcover.getText()))
                {

                    Toast.makeText(getApplicationContext(), "Please enter all fields", Toast.LENGTH_SHORT).show();

                }
                else {


                    data.edit().putString("checkboxStateManual", String.valueOf(editManual.getText())).apply();
                    data.edit().putString("checkboxStatusGraphics", String.valueOf(editGraphics.getText())).apply();
                    data.edit().putString("checkboxStateIndicator", String.valueOf(editIndicator.getText())).apply();
                    data.edit().putString("checkboxStateToolkit", String.valueOf(editToolkit.getText())).apply();
                    data.edit().putString("checkboxStateseat", String.valueOf(editSeatcover.getText())).apply();
                    data.edit().putString("Keys", String.valueOf(etKeys.getText())).apply();
                    data.edit().putString("BatteryMake", String.valueOf(etBatterymake.getText())).apply();
                    data.edit().putString("TyreMake", String.valueOf(etTyremake.getText())).apply();

                    Intent intent = new Intent(BikeCheckList.this, ServiceAdvisor.class);
                    startActivity(intent);
                    // finish();
                }

            }
        });

        buttonCancel = (Button)findViewById(R.id.btnCancel8);

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editManual.setText("");
                editIndicator.setText("");
                editGraphics.setText("");
                editSeatcover.setText("");
                editToolkit.setText("");
                etKeys.setText("");
                etBatterymake.setText("");
                etTyremake.setText("");
            }
        });

        buttonManualyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editManual.setText("Yes");
            }
        });

        buttonGraphicsyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editGraphics.setText("Yes");
            }
        });

        buttonIndicatoryes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editIndicator.setText("Yes");
            }
        });

        buttonToolkityes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editToolkit.setText("Yes");
            }
        });

        buttonSeatyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editSeatcover.setText("Yes");
            }
        });

        buttonManualno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editManual.setText("No");
            }
        });

        buttonGraphicsno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editGraphics.setText("No");
            }
        });

        buttonIndicatorno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editIndicator.setText("No");
            }
        });

        buttonToolkitno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editToolkit.setText("No");
            }
        });

        buttonSeatno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editSeatcover.setText("No");
            }
        });
    }

    private void loadSavedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);

        editManual.setText(sharedPreferences.getString("string_8_et1", ""));
        editGraphics.setText(sharedPreferences.getString("string_8_et2", ""));
        editIndicator.setText(sharedPreferences.getString("string_8_et3", ""));
        editToolkit.setText(sharedPreferences.getString("string_8_et4", ""));
        editSeatcover.setText(sharedPreferences.getString("string_8_et5", ""));
        editToolkit.setText(sharedPreferences.getString("string_8_et6", ""));
        etKeys.setText(sharedPreferences.getString("string_8_et11", ""));
        etBatterymake.setText(sharedPreferences.getString("string_8_et14", ""));
        etTyremake.setText(sharedPreferences.getString("string_8_et15", ""));
    }

    private void savePreferences(String key, String value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void saveData(){
        savePreferences("string_8_et1", editManual.getText().toString());
        savePreferences("string_8_et2", editGraphics.getText().toString());
        savePreferences("string_8_et3", editIndicator.getText().toString());
        savePreferences("string_8_et4", editToolkit.getText().toString());
        savePreferences("string_8_et5", editSeatcover.getText().toString());
        savePreferences("string_8_et6", editToolkit.getText().toString());
        savePreferences("string_8_et11", etKeys.getText().toString());
        savePreferences("string_8_et14", etBatterymake.getText().toString());
        savePreferences("string_8_et15", etTyremake.getText().toString());

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        saveData();
    }
}
