package com.example.raspisanie;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Database {

    public static String DB_PATH = "/data/data/com.example.raspisanie/databases/";
    public static String DB_NAME = "IP1.db";
    private static final String TAG = "MyActivity";
    private static Context mContext;

    public Database(Context context){
        mContext = context;
    }

    public String checkDataBase() {
        SQLiteDatabase checkDB = null;
        String.valueOf(mContext.getDatabasePath(DB_NAME));
        try {
            checkDB = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null,
                    SQLiteDatabase.OPEN_READWRITE);
            checkDB.close();
        } catch (SQLiteException e) {
            e.printStackTrace();
            setDefaultDataBase(mContext);
        } catch (Exception e) {
            e.printStackTrace();
            setDefaultDataBase(mContext);
        }
        return String.valueOf(mContext.getDatabasePath(DB_NAME));
    }

    public static void setDefaultDataBase(Context context) {
        try {
            InputStream myInput = context.getAssets().open(DB_NAME);
            // Path to the just created empty db
            String outFileName = DB_PATH + DB_NAME;
            //Open the empty db as the output stream
            OutputStream myOutput = new FileOutputStream(outFileName);
            //transfer bytes from the inputfile to the outputfile
            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            //Close the streams
            myOutput.flush();
            myOutput.close();
            myInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
