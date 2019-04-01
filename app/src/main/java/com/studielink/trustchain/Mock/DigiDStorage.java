package com.studielink.trustchain.Mock;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DigiDStorage extends SQLiteOpenHelper {

    private static final String TAG = "AccountStorage";

    private static final String TABLE_NAME = "account";
    private static final String COL1 = "ID";
    private static final String COL2 = "username";
    private static final String COL3 = "password";
    private static final String COL4 = "name";
    private static final String COL5 = "surname";
    private static final String COL6 = "age";

    public DigiDStorage(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME +
                "(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 + " TEXT, " +
                COL3 + " TEXT, " +
                COL4 + " TEXT, " +
                COL5 + " TEXT, " +
                COL6 + " NUMBER" +
                ")";

        db.execSQL(sql);

        insert(db,"bartvs98", "admin01", "Bart", "van Straaten", 20);
        insert(db,"thomas99", "admin01", "Thomas", "Mocellin", 19);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insert(SQLiteDatabase db, String item1, String item2, String item3, String item4, Integer item5) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, item1);
        contentValues.put(COL3, item2);
        contentValues.put(COL4, item3);
        contentValues.put(COL5, item4);
        contentValues.put(COL6, item5);

        Log.d(TAG, "insert: Inserting records into " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkAccExsitance(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME +
                    " WHERE " + COL2 + "='" + username + "'" +
                    " AND " + COL3 + "='" + password + "'";
        Cursor data = db.rawQuery(sql, null);

        if(data.getCount() <= 0){
            data.close();
            return false;
        }

        data.close();
        return true;
    }

    public Cursor getDataByUserName(String username){
//        Cursor data = sqLiteHelper.getDataByUserName(UserNameStorage.getUserName(this));
//        while(data.moveToNext()){
//            textView.setText(data.getString(1));
//        }

        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME +
                " WHERE " + COL2 + "='" + username + "'" ;
        Cursor data = db.rawQuery(sql, null);
        return data;
    }
}
