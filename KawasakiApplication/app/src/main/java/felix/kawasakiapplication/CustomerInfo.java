package felix.kawasakiapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerInfo extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner s1,s2;
    private Button buttonOK3,buttonCancel3;
    private EditText etOwnername,etAddress,etContact,etEmail,etBikeNumber,etEnginenumber,etKilometeres;
    SharedPreferences data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_info);
        data = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        etOwnername = (EditText)findViewById(R.id.input_ownername);
        etAddress = (EditText)findViewById(R.id.input_address);
        etContact = (EditText)findViewById(R.id.input_contact);
        etEnginenumber = (EditText)findViewById(R.id.input_enginenumber);
        etKilometeres = (EditText)findViewById(R.id.input_kilometers);
        etBikeNumber = (EditText)findViewById(R.id.input_bikenumber);
        etEmail = (EditText)findViewById(R.id.input_email);
        s1 = (Spinner)findViewById(R.id.spinner1);
        s2 = (Spinner)findViewById(R.id.spinner2);
        s1.setOnItemSelectedListener(this);
        loadSavedPreferences();

        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {


                if (s.length() > 0) {
                    if (!emailValidator(s)) {
                        etEmail.setError("Please Enter Valid Email!");
                    }
                }

            }
        });

        buttonOK3 = (Button)findViewById(R.id.btnok3);
        buttonCancel3 = (Button)findViewById(R.id.btncncl3);

        buttonCancel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etOwnername.setText("");
                etAddress.setText("");
                etContact.setText("");
                etEmail.setText("");
                etBikeNumber.setText("");
                etEnginenumber.setText("");
                etKilometeres.setText("");
            }
        });


        buttonOK3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(etOwnername.getText()) || TextUtils.isEmpty(etKilometeres.getText()) || TextUtils.isEmpty(etAddress.getText())
                        || TextUtils.isEmpty(etEmail.getText()) || TextUtils.isEmpty(etContact.getText())
                        || TextUtils.isEmpty(etEnginenumber.getText())
                        || TextUtils.isEmpty(etBikeNumber.getText())){
                    Toast.makeText(getApplicationContext(), "Please enter all fields", Toast.LENGTH_SHORT).show();

                }
                else if(etContact.getText().length() < 10){
                    Toast.makeText(CustomerInfo.this,"Please enter a valid mobile number",Toast.LENGTH_SHORT).show();
                }

                else {
                    Intent intent = new Intent(CustomerInfo.this, ServiceActivity.class);
                    //SharedPreferences
                    data.edit().putString("Ownername", etOwnername.getText().toString()).apply();
                    data.edit().putString("Address", String.valueOf(etAddress.getText())).apply();
                    data.edit().putString("Contact", String.valueOf(etContact.getText())).apply();
                    data.edit().putString("Enginenumber", String.valueOf(etEnginenumber.getText())).apply();
                    data.edit().putString("Kilometers", String.valueOf(etKilometeres.getText())).apply();
                    data.edit().putString("BikeNumber", String.valueOf(etBikeNumber.getText())).apply();
                    data.edit().putString("Email", String.valueOf(etEmail.getText())).apply();
                    data.edit().putString("BikeSeries",String.valueOf(s1.getSelectedItem())).apply();
                    data.edit().putString("BikeModel",String .valueOf(s2.getSelectedItem())).apply();
                    startActivity(intent);
                }
            }
        });
    }

    public boolean emailValidator(CharSequence email){
        Pattern pattern1 = Pattern.compile("^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\\.([a-zA-Z])+([a-zA-Z])+");

        Matcher matcher1 = pattern1.matcher(email);

        return matcher1.matches();
    }

    private void loadSavedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);

        etOwnername.setText(sharedPreferences.getString("string_et1", ""));
        etAddress.setText(sharedPreferences.getString("string_et2", ""));
        etContact.setText(sharedPreferences.getString("string_et3", ""));
        etEnginenumber.setText(sharedPreferences.getString("string_et5", ""));
        etKilometeres.setText(sharedPreferences.getString("string_et7", ""));
        etBikeNumber.setText(sharedPreferences.getString("string_et8", ""));
        etEmail.setText(sharedPreferences.getString("string_et9", ""));

    }

    private void savePreferences(String key, String value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void saveData(){
        savePreferences("string_et1", etOwnername.getText().toString());
        savePreferences("string_et2", etAddress.getText().toString());
        savePreferences("string_et3", etContact.getText().toString());
        savePreferences("string_et5", etEnginenumber.getText().toString());
        savePreferences("string_et7", etKilometeres.getText().toString());
        savePreferences("string_et8", etBikeNumber.getText().toString());
        savePreferences("string_et9", etEmail.getText().toString());

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String sp1= String.valueOf(s1.getSelectedItem());

        if(sp1.contentEquals("NINJA")) {
            List<String> list = new ArrayList<String>();
            list.add("Ninja H2(2017)");
            list.add("Ninja ZX-10R(2017)");
            list.add("Ninja ZX-14R(2017)");
            list.add("Ninja 1000(2017)");
            list.add("Ninja 650");
            list.add("Ninja 300(2017)");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            s2.setAdapter(dataAdapter);
        }

        if(sp1.contentEquals("Z")) {
            List<String> list = new ArrayList<String>();
            list.add("Z800(2017)");
            list.add("Z1000(2017)");
            list.add("Z250(2017)");
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            s2.setAdapter(dataAdapter2);
        }

        if(sp1.contentEquals("VERSYS")) {
            List<String> list = new ArrayList<String>();
            list.add("Versys 1000(2016)");
            list.add("Versys 650(2016)");
            ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter3.notifyDataSetChanged();
            s2.setAdapter(dataAdapter3);
        }

        if(sp1.contentEquals("ER")) {
            List<String> list = new ArrayList<String>();
            list.add("ER-6n");
            ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter4.notifyDataSetChanged();
            s2.setAdapter(dataAdapter4);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onBackPressed() {
        saveData();
        return;
    }
}
