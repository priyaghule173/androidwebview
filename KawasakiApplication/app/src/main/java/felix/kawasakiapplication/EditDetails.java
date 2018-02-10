package felix.kawasakiapplication;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditDetails extends AppCompatActivity {

    SharedPreferences data;
    Button buttonOK;
    EditText etcustname,etcustnumber,etcustaddress,etengineno,etmileage,etadvisorname,etadvisornumber,etdrivername,etdrivernumber;
    EditText etwov1,etwov2,etwov3,etemail,etBikenumber,etbikeseries,etbikemodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_details);

        buttonOK  = (Button)findViewById(R.id.btnokedit);
        etcustname = (EditText)findViewById(R.id.idownername);
        etcustnumber = (EditText)findViewById(R.id.idownerphone);
        etcustaddress = (EditText)findViewById(R.id.idowneraddress);
        etengineno = (EditText)findViewById(R.id.idengine);
        etmileage = (EditText)findViewById(R.id.idmileage);
        etadvisorname = (EditText)findViewById(R.id.idadvisorname);
        etadvisornumber = (EditText)findViewById(R.id.idadvisornumber);
        etdrivername = (EditText)findViewById(R.id.iddrivername);
        etdrivernumber = (EditText)findViewById(R.id.iddrivernumber);
        etwov1 = (EditText)findViewById(R.id.idwov1);
        etwov2 = (EditText)findViewById(R.id.idwov2);
        etwov3 = (EditText)findViewById(R.id.idwov3);
        etemail = (EditText)findViewById(R.id.iddemail);
        etBikenumber = (EditText)findViewById(R.id.idbikenumber);
        etbikeseries = (EditText)findViewById(R.id.idbikeseries);
        etbikemodel = (EditText)findViewById(R.id.idbiketype);

        data = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        String oname = data.getString("Ownername", "THIS IS DEFAULT VALUE");
        String add = data.getString("Address", "THIS IS DEFAULT VALUE");
        String ctact = data.getString("Contact", "8087696063");
        String oEmail = data.getString("Email", "user@domain.com");
        String kmeters = data.getString("Kilometers", "THIS IS DEFAULT VALUE");
        String eNumber = data.getString("Enginenumber", "THIS IS DEFAULT VALUE");
        String firstrequest = data.getString("UserRequest1", "THIS IS DEFAULT VALUE");
        String secondrequest = data.getString("UserRequest2", "THIS IS DEFAULT VALUE");
        String thirdrequest = data.getString("UserRequest3", "THIS IS DEFAULT VALUE");
        String drname = data.getString("DriverName", "THIS IS DEFAULT VALUE");
        String dnumber = data.getString("DriverNumber", "132456789");
        String aName = data.getString("AdvisorName", "THIS IS DEFAULT VALUE");
        String aNumber = data.getString("AdvisorNumber", "123456798");
        String bikenumber = data.getString("BikeNumber","MH12000000");
        String bikeSeries = data.getString("BikeSeries","");
        String bikeModel = data.getString("BikeModel","");

        etcustname.setText(oname);
        etcustnumber.setText(ctact);
        etcustaddress.setText(add);
        etengineno.setText(eNumber);
        etmileage.setText(kmeters);
        etadvisorname.setText(aName);
        etadvisornumber.setText(aNumber);
        etdrivername.setText(drname);
        etdrivernumber.setText(dnumber);
        etwov1.setText(firstrequest);
        etwov2.setText(secondrequest);
        etwov3.setText(thirdrequest);
        etemail.setText(oEmail);
        etBikenumber.setText(bikenumber);
        etbikeseries.setText(bikeSeries);
        etbikemodel.setText(bikeModel);

        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(EditDetails.this, FinalScreen.class);

                data.edit().putString("CEmail", etemail.getText().toString()).apply();
                data.edit().putString("Cname", etcustname.getText().toString()).apply();
                data.edit().putString("Cnumber", etcustnumber.getText().toString()).apply();
                data.edit().putString("Caddress", etcustaddress.getText().toString()).apply();
                data.edit().putString("BikeEngineNumber", etengineno.getText().toString()).apply();
                data.edit().putString("BikeMileage", etmileage.getText().toString()).apply();
                data.edit().putString("BikeAdvisorName", etadvisorname.getText().toString()).apply();
                data.edit().putString("BikeAdvisorNumber", etadvisornumber.getText().toString()).apply();
                data.edit().putString("BikeDriverName", etdrivername.getText().toString()).apply();
                data.edit().putString("BikeDriverNumber", etdrivernumber.getText().toString()).apply();
                data.edit().putString("Request_From_User_1", etwov1.getText().toString()).apply();
                data.edit().putString("Request_From_User_2", etwov2.getText().toString()).apply();
                data.edit().putString("Request_From_User_3", etwov3.getText().toString()).apply();

                startActivity(intent);
                finish();

            }
        });

    }
}
