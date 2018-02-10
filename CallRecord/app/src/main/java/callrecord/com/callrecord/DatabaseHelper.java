package callrecord.com.callrecord;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sagoo on 12/3/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="Employee.db";
    public static final String TABLE_NAME="Employee_table";
    public static final String Col_1="NAME";
    public static final String Col_2="ADDRESS";
    public static final String Col_3="MOBILE_NO";
    public static final String Col_4="EMAIL";
    public static final String Col_5="REFERENCE";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create Table " + TABLE_NAME + " (NAME TEXT,ADDRESS TEXT,MOBILE_NO TEXT,EMAIL TEXT,REFERENCE SPINNER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }
    public boolean insertData(String name,String address,String mobile_no,String email,String reference){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Col_1,name);
        contentValues.put(Col_2,address);
        contentValues.put(Col_3,mobile_no);
        contentValues.put(Col_4,email);
        contentValues.put(Col_5,reference);

        long result=sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }
    public Cursor getAllData()
    {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor res=sqLiteDatabase.rawQuery("Select * from " +TABLE_NAME,null);
        return res;

    }

    public Cursor getEmployeeData(String name)
    {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor res=sqLiteDatabase.rawQuery("Select * from " +TABLE_NAME+ " where Name='"+name+"'",null);
        return res;
    }
}
