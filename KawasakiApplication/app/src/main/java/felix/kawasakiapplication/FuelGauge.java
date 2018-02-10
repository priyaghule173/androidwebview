package felix.kawasakiapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import pl.pawelkleczkowski.customgauge.CustomGauge;

public class FuelGauge extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView textView;
    private CustomGauge gauge3;
    private Button buttonSave,buttonOk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_gauge);
        initializeVariables();

        textView.setText(String.valueOf(seekBar.getProgress()));

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                progress = progressValue;
                gauge3.setValue(progressValue);
                textView.setText(String.valueOf(seekBar.getProgress()) + "%");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RelativeLayout content = (RelativeLayout) findViewById(R.id.guageLayout);
                content.setDrawingCacheEnabled(true);
                Bitmap bitmap = content.getDrawingCache();
                String root = Environment.getExternalStorageDirectory().toString();

                File file = new File(root + "/Kawasaki/saved_fuelGauge");
                if (!file.exists()) {
                    file.mkdirs();

                }
                String fname = "FuelGuage.png";
                File f = new File(file, fname);
                try {
                    FileOutputStream ostream = new FileOutputStream(f);
                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, ostream);
                    ostream.flush();
                    ostream.close();
                    Toast.makeText(FuelGauge.this, "Fuel Gauge saved.", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {

                }

            }
        });

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FuelGauge.this,ImageDraw.class);
                startActivity(intent);
            }
        });
    }

    private void initializeVariables() {
        seekBar = (SeekBar) findViewById(R.id.seekBar1);
        textView = (TextView) findViewById(R.id.textView2);
        gauge3 = (CustomGauge) findViewById(R.id.gauge3);
        buttonSave = (Button)findViewById(R.id.btnSAVE7);
        buttonOk = (Button)findViewById(R.id.btnOK7);
    }

}
