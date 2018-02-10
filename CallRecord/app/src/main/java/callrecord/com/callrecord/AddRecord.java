package callrecord.com.callrecord;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class AddRecord extends AppCompatActivity {


    EditText etname, etaddress, etmobile, etemail;
    Button btsubmit;
    Spinner spinner;
    DatabaseHelper MyDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        MyDb = new DatabaseHelper(this);

        etname = (EditText) findViewById(R.id.etFName);
        etaddress = (EditText) findViewById(R.id.etAddress);
        etmobile = (EditText) findViewById(R.id.etMobile);
        etemail = (EditText) findViewById(R.id.etEmail);
        btsubmit = (Button) findViewById(R.id.btnSubmit);


        spinner = (Spinner) findViewById(R.id.spinner);

        ArrayList<String>arrayList=new ArrayList<String>();
        for(int i=0;i<5;i++)
        {
            arrayList.add(String.valueOf(i));
        }
        ArrayAdapter<String> MyAdapter = new ArrayAdapter<String>(AddRecord.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));
        MyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(MyAdapter);
        AddData();


    }

    public void AddData() {
        btsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etemail.getText().toString().contains("@")) {
                    if (etmobile.getText().toString().length() >= 10) {


                        boolean insert = MyDb.insertData(etname.getText().toString(), etaddress.getText().toString(), etmobile.getText().toString(), etemail.getText().toString(), spinner.getSelectedItem().toString());

                        if (insert = true) {
                            Toast.makeText(AddRecord.this, "Data inserted", Toast.LENGTH_LONG).show();
//                            Intent intent = new Intent(AddRecord.this, EmployeeRecord.class);
//                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(AddRecord.this, "Data not inserted", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(AddRecord.this, "Invalid Mobile_no ", Toast.LENGTH_SHORT).show();
                    }

                    } else {
                        Toast.makeText(AddRecord.this, "Invalid Email Id", Toast.LENGTH_SHORT).show();
                    }


            }
        });

    }
}