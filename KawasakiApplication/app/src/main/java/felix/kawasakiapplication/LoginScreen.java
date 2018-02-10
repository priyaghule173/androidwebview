package felix.kawasakiapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity implements View.OnClickListener{

    private EditText name;
    private EditText password;
    private Button btnOk,btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        name = (EditText)findViewById(R.id.input_username);
        password = (EditText)findViewById(R.id.input_password);
        btnOk = (Button)findViewById(R.id.btnok);
        btnCancel = (Button)findViewById(R.id.btncncl);

        btnOk.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnok:

                if(TextUtils.isEmpty(name.getText()) || TextUtils.isEmpty(password.getText())){
                    Toast.makeText(getApplicationContext(), "Please enter all fields", Toast.LENGTH_SHORT).show();

                }
                else {
                    if (TextUtils.equals(name.getText(), "admin") && TextUtils.equals(password.getText(), "admin@123")) {

                        Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginScreen.this, CustomerInfo.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Login UnSuccessful", Toast.LENGTH_SHORT).show();
                    }
                }
                break;

            case R.id.btncncl:
                name.setText("");
                password.setText("");
                break;
        }
    }
}
