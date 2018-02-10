package callrecord.com.callrecord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {


    EditText etUsername,etPassword;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername= (EditText) findViewById(R.id.etUsername1);
        etPassword= (EditText) findViewById(R.id.etPassword);

        btnLogin= (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etUsername.getText().toString().equals("Admin") && etPassword.getText().toString().equals("Admin123"))
                {
                    Toast.makeText(Login.this,"User and password is correct",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Login.this,ManagerActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(Login.this,"User and password is Incorrect",Toast.LENGTH_SHORT).show();

                }


            }
        });

    }
}
