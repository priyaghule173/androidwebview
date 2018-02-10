package callrecord.com.callrecord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EmployeeRecord extends AppCompatActivity {

    Button btAddRecord,btEndRecord,btBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_record);

        btAddRecord=(Button)findViewById(R.id.btnAdd);
        btEndRecord=(Button)findViewById(R.id.btnEnd);

        AddRecord();
        EndRecord();


    }
    public void AddRecord()
    {
        btAddRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(EmployeeRecord.this,AddRecord.class);
                startActivity(intent);
            }
        });
    }
    public void EndRecord()
    {
        btEndRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(EmployeeRecord.this,EndRecord.class);
                startActivity(intent);

            }
        });
    }
}
