package felix.kawasakiapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class ImageDraw extends Activity implements View.OnClickListener{

    protected Button buttonScratch,buttonDent,buttonSave,buttonDone;
    DrawableImageView mDrawingView;
    LinearLayout mDrawingPad;
    EditText editDamage;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_draw);

        mDrawingView=new DrawableImageView(this);
        mDrawingPad=(LinearLayout)findViewById(R.id.view_drawing_pad);
        mDrawingPad.addView(mDrawingView);
        editDamage = (EditText)findViewById(R.id.etDamage);
        buttonDent = (Button)findViewById(R.id.btnDent);
        buttonScratch = (Button)findViewById(R.id.btnScratch);
        buttonSave = (Button)findViewById(R.id.btnSaveImage);
        buttonDone = (Button)findViewById(R.id.btnDoneImage);


        buttonDent.setOnClickListener(this);
        buttonScratch.setOnClickListener(this);
        buttonSave.setOnClickListener(this);
        buttonDone.setOnClickListener(this);

        //View viewTouch = getWindow().getDecorView();

      /*  mDrawingPad.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        float x = event.getX();
                        float y = event.getY();

                        if (x > 800 && x < 1000) {
                            Toast.makeText(ImageDraw.this, "Clicked", Toast.LENGTH_SHORT).show();
                            editDamage.setText("Damage");
                            Log.d("Touch Event", "touch");
                        }
                        break;
                }
                return true;
            }
        }); */

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnDent:
                mDrawingView.mPaint.setColor(0xFF000000);
                break;

            case R.id.btnScratch:
               mDrawingView.mPaint.setColor(0xFFFF0000);
                break;


            case R.id.btnSaveImage:

                LinearLayout mlinear = (LinearLayout)findViewById(R.id.linearLayout);
                mlinear.setDrawingCacheEnabled(true);
                Bitmap bitmap = mlinear.getDrawingCache();
                String root = Environment.getExternalStorageDirectory().toString();

                File file = new File(root + "/Kawasaki/saved_BikeDamage");
                if (!file.exists()) {
                    file.mkdirs();
                }
                String fname = "BikeDamage.png";
                File f = new File(file, fname);

                try {
                    FileOutputStream ostream = new FileOutputStream(f);
                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, ostream);
                    ostream.flush();
                    ostream.close();
                    Toast.makeText(ImageDraw.this, "Bike Saved.", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                }
                break;

            case R.id.btnDoneImage:
                Intent intent = new Intent(ImageDraw.this,BikeCheckList.class);
                startActivity(intent);
                break;
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mDrawingView.touch_start(x, y);
                Log.d("Co-ords down", String.valueOf(x) + "," + String.valueOf(y));
                mDrawingView.invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                mDrawingView.touch_move(x, y);

             /*   if(mDrawingView.mPaint.getColor()==0xFF000000 && x>1000 && x< 1370 && y>990 && y<1100 )
                {
                    if(!editDamage.getText().toString().contains("Right side mirror Dented"))
                    {
                        editDamage.setText("Right side mirror Dented");
                    }
                }
                else if(mDrawingView.mPaint.getColor()==0xFFFF0000 && x>1000 && x< 1370 && y>990 && y<1100 ){

                    if(!editDamage.getText().toString().contains("Right side mirror Scratched")) {
                        editDamage.setText("Right side mirror Scratched");
                    }
                }*/
                mDrawingView.invalidate();
                Log.d("Co-ords move", String.valueOf(x) + "," + String.valueOf(y));
                break;
            case MotionEvent.ACTION_UP:
                mDrawingView.touch_up();
                mDrawingView.invalidate();
                Log.d("Co-ords up", String.valueOf(x) + "," + String.valueOf(y));
                break;
        }
        return true;
    }

}
