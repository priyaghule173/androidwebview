package felix.kawasakiapplication;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener{
    private RadioButton btn1,btn2;
    SharedPreferences data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        data = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        btn1 = (RadioButton)findViewById(R.id.rbtnfree);
        btn2 = (RadioButton)findViewById(R.id.rbtnpaid);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.rbtnfree:

                final Dialog dialog = new Dialog(ServiceActivity.this);
                dialog.setTitle("Free Service");
                dialog.setContentView(R.layout.dialog);
                dialog.show();
                final EditText etService = (EditText)dialog.findViewById(R.id.serviceOffered);
                etService.setText("Bike Wash , Checkup , Oil Change");

                Button btnOk = (Button)dialog.findViewById(R.id.dialog_ok);
                btnOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ServiceActivity.this,RequestScreen.class);
                        data.edit().putString("ServiceDetails", String.valueOf(etService.getText())).apply();
                        startActivity(intent);
                          finish();
                    }
                });

                Button btnCancel = (Button)dialog.findViewById(R.id.dialog_cancel);
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                break;

            case R.id.rbtnpaid:
                final Dialog dialog1 = new Dialog(ServiceActivity.this);
                dialog1.setTitle("Paid Service");
                dialog1.setContentView(R.layout.dialog);
                dialog1.show();

                final EditText etService1 = (EditText)dialog1.findViewById(R.id.serviceOffered);
                etService1.setText("Oil Change & other fluids , Check & replace damaged bike parts , Other customer requests ");

                Button btnOk1 = (Button)dialog1.findViewById(R.id.dialog_ok);
                btnOk1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ServiceActivity.this,RequestScreen.class);
                        data.edit().putString("ServiceDetails", String.valueOf(etService1.getText())).apply();
                       startActivity(intent);
                        finish();
                    }
                });

                Button btnCancel1 = (Button)dialog1.findViewById(R.id.dialog_cancel);
                btnCancel1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog1.cancel();
                    }
                });

                break;

        }

    }
}
