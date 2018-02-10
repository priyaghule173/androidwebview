package callrecord.com.callrecord;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.jar.Attributes;

public class EndRecord extends AppCompatActivity implements View.OnClickListener{

    Spinner spinner2,spinner3;
    DatabaseHelper MyDb;
    DatabaseHelper2 MyDb1;
    TextView etdatePicker;
    Button submit;
    String employeeName;
    String empAddress;
    String empMobileNo;
    String empEmail;
    String empReference;
    SimpleDateFormat dateFormatter;
    DatePickerDialog datePickerDialog;
    int namePosition;
    ArrayList<String> arrayList=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_record);
        dateFormatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
        MyDb1 = new DatabaseHelper2(this);
        MyDb = new DatabaseHelper(this);
        spinner2 = (Spinner) findViewById(R.id.spinnerRoute);
        spinner3 = (Spinner) findViewById(R.id.spinner2);
        submit= (Button) findViewById(R.id.btnSubmit);
        etdatePicker= (TextView) findViewById(R.id.date);




        Cursor res = MyDb.getAllData();
        if (res.getCount() == 0) {
            Toast.makeText(EndRecord.this, "Data not inserted", Toast.LENGTH_LONG).show();
            return;

        }else {
            while (res.moveToNext()) {
                arrayList.add(res.getString(0));

            }
        }
        if(arrayList!=null)
        {
            ArrayAdapter<String> MyAdapter = new ArrayAdapter<String>(EndRecord.this,
                    android.R.layout.simple_list_item_1, arrayList);
            MyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner3.setAdapter(MyAdapter);
            spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    Cursor res = MyDb.getEmployeeData(arrayList.get(i).toString());
                    if (res.getCount() == 0) {
                        Toast.makeText(EndRecord.this, "Data not inserted", Toast.LENGTH_LONG).show();
                        return;

                    }else {
                        while (res.moveToNext()) {
                          //  arrayList.add(res.getString(0));

                            employeeName=res.getString(0);
                            empAddress=res.getString(1);
                            empMobileNo=res.getString(2);
                            empEmail=res.getString(3);
                            empReference=res.getString(4);
                            Log.i("emp data",res.getString(0));
                            Log.i("emp data",res.getString(1));
                            Log.i("emp data",res.getString(2));
                            Log.i("emp data",res.getString(3));
                            Log.i("emp data",res.getString(4));
                        }
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
         }


        ArrayAdapter<String> MyAdapter = new ArrayAdapter<String>(EndRecord.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.name));
        MyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(MyAdapter);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etdatePicker.getText().toString().equalsIgnoreCase("DD-MM-YYYY"))
                {
                    Toast.makeText(EndRecord.this, "Please select valid date", Toast.LENGTH_LONG).show();
                }else {


                    boolean insert = MyDb1.insertData(employeeName, empAddress, empMobileNo, empEmail, empReference, etdatePicker.getText().toString(), spinner2.getSelectedItem().toString());

                    if (insert = true) {
                        Toast.makeText(EndRecord.this, "Successfully Inserted", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(EndRecord.this, EndRecord.class);
//                    startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(EndRecord.this, "Data not inserted", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
        setDateTimeField();
    }
    @Override
    public void onClick(View view) {
        if (view == etdatePicker) {
            datePickerDialog.show();
        }
    }
    private void setDateTimeField() {
        etdatePicker.setOnClickListener(this);
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(EndRecord.this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                etdatePicker.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());



    }

  }





