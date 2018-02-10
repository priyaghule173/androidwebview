package felix.kawasakiapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FinalScreen extends AppCompatActivity {

   Button btnGeneratepdf,sendPdf,donebtn;
    SharedPreferences data;
    File myFile;
   String request_user1,request_user2,request_user3;
   String ownername,currentDateandTime,address,contact,bikenumber,engineNumber,drivername,drivernumber,advisorName,advisorNumber;
   String chkmanual,kilometers,ownerEmail,chkgraphics,chkindicator,chktoolkit,chkseat;
    String keys,batterymake,tyremake;
    String bikeSeries,bikeType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_screen);

        btnGeneratepdf = (Button) findViewById(R.id.generatepdf);
        sendPdf = (Button)findViewById(R.id.sendpdf);
        donebtn = (Button)findViewById(R.id.done);

        data = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        ownername = data.getString("Cname", "THIS IS DEFAULT VALUE");
        address = data.getString("Caddress", "THIS IS DEFAULT VALUE");
        contact = data.getString("Cnumber", "8087696063");
        ownerEmail = data.getString("CEmail", "user@domain.com");
        bikenumber = data.getString("BikeNumber", "THIS IS DEFAULT VALUE");
        engineNumber = data.getString("BikeEngineNumber", "THIS IS DEFAULT VALUE");
        kilometers = data.getString("BikeMileage", "THIS IS DEFAULT VALUE");
        drivername = data.getString("BikeDriverName", "THIS IS DEFAULT VALUE");
        drivernumber = data.getString("BikeDriverNumber", "132456789");
        String driverlicense = data.getString("DriverLicense", "THIS IS DEFAULT VALUE");
        advisorName = data.getString("BikeAdvisorName", "THIS IS DEFAULT VALUE");
        advisorNumber = data.getString("BikeAdvisorNumber", "123456798");
        bikeSeries = data.getString("BikeSeries","");
        bikeType = data.getString("BikeModel","");

        request_user1 = data.getString("Request_From_User_1","No request from customer");
        request_user2 = data.getString("Request_From_User_2","");
        request_user3 = data.getString("Request_From_User_3","");

        keys = data.getString("Keys","0");
        batterymake = data.getString("BatteryMake","Default value");
        tyremake = data.getString("TyreMake", "Default value");

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        chkmanual = String.valueOf(sharedPreferences.getString("checkboxStateManual", "Default"));
        chkgraphics = sharedPreferences.getString("checkboxStatusGraphics", "Default");
        chkindicator = sharedPreferences.getString("checkboxStateIndicator", "Default");
        chktoolkit = sharedPreferences.getString("checkboxStateToolkit","Default");
        chkseat = sharedPreferences.getString("checkboxStateseat","Default");

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        currentDateandTime = sdf.format(new Date());

        sendPdf.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {

                            GMailSender sender = new GMailSender("sanket.kanwar04@gmail.com", "flygon04");
                            sender.addAttachment(myFile.getAbsolutePath());

                            Log.d("Path is ", myFile.getAbsolutePath());
                            sender.sendMail("Your Kawasaki " + bikeSeries + " " + bikeType + " job sheet", "Hello " + ownername +", Please check your Kawasaki bike job sheet",
                                    "Sanket", ownerEmail);
                        } catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();

                        }

                    }
                }).start();
                Toast.makeText(getApplicationContext(), "Email sent successfully to " + ownerEmail, Toast.LENGTH_SHORT).show();
                donebtn.setVisibility(View.VISIBLE);
            }
        });

        donebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = data.edit();
                editor.clear();
                editor.commit();
                Intent intent = new Intent(FinalScreen.this,CustomerInfo.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

        btnGeneratepdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    createPdf();
                } catch (DocumentException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(),"PDF Successfully Saved",Toast.LENGTH_SHORT).show();
                sendPdf.setVisibility(View.VISIBLE);

              /*  OutputStream output = null;
                PdfReader reader = null;

                try {
                    reader = new PdfReader(getResources().openRawResource(R.raw.toyotainvoice));
                    PdfStamper stamper = new PdfStamper(reader, output);
                    AcroFields acroFields = stamper.getAcroFields();
                    acroFields.setField("Customer_Name", customerDetails.getCust_name());
                    acroFields.setField("Mobile", String.valueOf(customerDetails.getCust_mobile()));
                    stamper.setFormFlattening(true);
                    stamper.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                catch (DocumentException e) {
                    e.printStackTrace();
                }*/

            }
        });

    }

    private void createPdf() throws FileNotFoundException, DocumentException, IOException {

        String root = Environment.getExternalStorageDirectory().toString();
        File file = new File(root + "/Kawasaki/saved_PDF");
       /* File pdfFolder = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOCUMENTS), "pdfdemo");*/
        if (!file.exists()) {
            file.mkdirs();
        }

        //Create time stamp
        Date date = new Date();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(date);

        String fname = timeStamp + ownername +".pdf";

        // myFile = new File(file + timeStamp + ownername +".pdf"); //add customer name .
        myFile = new File(file,fname);

        FileOutputStream output = new FileOutputStream(myFile);

        //reader = null;
        PdfReader reader = new PdfReader(getResources().openRawResource(R.raw.kawasaki_pdf));
        PdfStamper stamper = new PdfStamper(reader, output);
        AcroFields acroFields = stamper.getAcroFields();
        acroFields.setField("Customer_Name", ownername);
        acroFields.setField("Address", address);
        acroFields.setField("Mobile", contact);

        acroFields.setField("Bike_Series", bikeSeries);
        acroFields.setField("Bike_Model", bikeType);
        acroFields.setField("Registration_No", bikenumber);

        acroFields.setField("Invoice_Date_Time",currentDateandTime);
        acroFields.setField("Mileage_In_Date",kilometers);

        acroFields.setField("Engine_No", engineNumber);

        acroFields.setField("Service_Advisor", advisorName);
        acroFields.setField("Service_Advisor_Number", advisorNumber);
        acroFields.setField("Driver_Name", drivername);
        acroFields.setField("Driver_Mobile", drivernumber);

        acroFields.setField("Manual",chkmanual);
        acroFields.setField("Bike_Graphics", chkgraphics);
        acroFields.setField("Indicators",chkindicator);
        acroFields.setField("Seat_Cover",chkseat);
        acroFields.setField("Toolkit",chktoolkit);

        acroFields.setField("Keys",keys);

        acroFields.setField("Battery_Make", batterymake);
        acroFields.setField("Tyre_Make", tyremake);
        acroFields.setField("user_request_1",request_user1);
        acroFields.setField("user_request_2",request_user2);
        acroFields.setField("user_request_3",request_user3);


        PdfContentByte content = stamper.getOverContent(reader.getNumberOfPages());
        Image image = Image.getInstance("sdcard/Kawasaki/saved_BikeDamage/BikeDamage.png");
        Image image1 = Image.getInstance("sdcard/Kawasaki/saved_fuelGauge/FuelGuage.png");
        Image image2 = Image.getInstance("sdcard/Kawasaki/saved_signature/signature.png");
        image.setAbsolutePosition(80, 250);
        image1.setAbsolutePosition(220, 230);
        image2.setAbsolutePosition(50, 145);
        image.scaleAbsolute(100, 100);
        image1.scaleAbsolute(100, 100);
        image2.scaleAbsolute(200,40);
        content.addImage(image);
        content.addImage(image1);
        content.addImage(image2);
        stamper.setFormFlattening(true);
        stamper.close();
        reader.close();
        output.flush();
        output.close();

        //Step 1
      /*  Document document = new Document();

        //Step 2
        PdfWriter.getInstance(document, output);

        //Step 3
        document.open();

        //Step 4 Add content
        document.add(new Paragraph(mSubjectEditText.getText().toString()));
        document.add(new Paragraph(mBodyEditText.getText().toString()));

        //Step 5: Close the document
        document.close();*/

    }



}
