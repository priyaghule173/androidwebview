package felix.kawasakiapplication;

import android.app.Activity;
import android.os.Bundle;


public class SignatureMain extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new SignatureMainLayout(this));
    }
}