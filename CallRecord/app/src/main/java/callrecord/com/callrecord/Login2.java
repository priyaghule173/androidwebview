package callrecord.com.callrecord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login2 extends AppCompatActivity {

    EditText etUsername,etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        etUsername= (EditText) findViewById(R.id.etUsername1);
        etPassword= (EditText) findViewById(R.id.etPassword);

        btnLogin= (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etUsername.getText().toString().equals("user") && etPassword.getText().toString().equals("12345"))
                {
                    Toast.makeText(Login2.this,"User and password is correct",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Login2.this,EmployeeRecord.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(Login2.this,"User and password is Incorrect",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
