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

public class ManagerActivity extends AppCompatActivity implements View.OnClickListener{


    DatabaseHelper MyDb;
    DatabaseHelper2 MyDb1;
    TextView etdatePicker;
    Button submit;
    String date;
    String month;
    SimpleDateFormat dateFormatter;
    DatePickerDialog datePickerDialog;
    int namePosition;
    ArrayList<String> arrayList=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        dateFormatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
        MyDb1 = new DatabaseHelper2(this);
        MyDb = new DatabaseHelper(this);

        submit= (Button) findViewById(R.id.btnSubmit);
        etdatePicker= (TextView) findViewById(R.id.date);




        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              date=etdatePicker.getText().toString();
                String month1[]=date.split("-");
                if(month1.length==3)
                {
                    month=month1[1];
                }
                Log.i("month",month);


                Cursor res=MyDb1.getManagerData(month);
                if(res.getCount()==0)
                {
                    showMessage("Error", "Nothing Found");
                    return;

                }
                StringBuffer buffer=new StringBuffer();
                while (res.moveToNext())
                {
                    buffer.append("Name :"+res.getString(0)+"\n");
                    buffer.append("Address :"+res.getString(1)+"\n");
                    buffer.append("Mobile_No :"+res.getString(2)+"\n");
                    buffer.append("Email :"+res.getString(3)+"\n");
                    buffer.append("Reference :"+res.getString(4)+"\n");
                    buffer.append("Visited :"+res.getString(5)+"\n");
                    buffer.append("Route :"+res.getString(6)+"\n\n");

                }
                showMessage("Data",buffer.toString());
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

public void showMessage(String title,String Message)
        {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();


        }
    private void setDateTimeField() {
        etdatePicker.setOnClickListener(this);
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(ManagerActivity.this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                etdatePicker.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());



    }

}





