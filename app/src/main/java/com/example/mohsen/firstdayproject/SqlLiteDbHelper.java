package com.example.mohsen.firstdayproject;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.Display;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import models.Model;

public class SqlLiteDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "mybooks";
    private static final String DB_PATHSUFFIX = "/databases/";
    private static final String TAG = "sqlite database helper ";
    static Context mctx;

    SqlLiteDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        mctx = context;
    }


    public ArrayList<Model> getDetails(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Model> modelArrayList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM mybooks.booktable",null);
        if(cursor != null){
            Log.d(TAG, "getDetails: ");
            while (cursor.moveToNext()){
                Model count = new Model(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3));
                modelArrayList.add(count);
            }
            cursor.close();
            db.close();
        }

        return  modelArrayList;
    }

    public void CopyDataBaseFromAssets()throws IOException {
        InputStream inputStream = mctx.getAssets().open(DATABASE_NAME);

        String outFileName = getDatabasePath();

        File f = new File (mctx.getApplicationInfo().dataDir + DB_PATHSUFFIX);

        if(!f.exists()){
            f.mkdir();
        }

        OutputStream outputStream = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int length;

        while ((length = inputStream.read(buffer)) >0){
            outputStream.write(buffer,0,length);
        }

        outputStream.flush();
        outputStream.close();
        inputStream.close();

    }

    private static String getDatabasePath() {
        return mctx.getApplicationInfo().dataDir + DB_PATHSUFFIX + DATABASE_NAME;
    }

    public SQLiteDatabase openDataBase() throws SQLException {
        File dbFile = mctx.getDatabasePath(DATABASE_NAME);

        if (!dbFile.exists()){
            try {
                CopyDataBaseFromAssets();
                Toast.makeText(mctx, "copying success from database ", Toast.LENGTH_SHORT).show();
            }catch (IOException e){
                throw new RuntimeException("error creating source database");
            }
        }
        return SQLiteDatabase.openDatabase(dbFile.getPath(),null,SQLiteDatabase.NO_LOCALIZED_COLLATORS | SQLiteDatabase.CREATE_IF_NECESSARY);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
