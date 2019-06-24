package nl.tudelft.cs4160.trustchain_android.Storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.time.LocalDateTime;

public class StudentAccountStorage extends SQLiteOpenHelper {

    private static final String TAG = "StudentAccountStorage";

    private static final String TABLE_NAME = "studentaccount";
    private static final String COL1 = "ID";
    private static final String COL2 = "username";
    private static final String COL3 = "name";
    private static final String COL4 = "surname";
    private static final String COL5 = "age";
    private static final String COL6 = "paid";
    private static final String COL7 = "date";
    private static final String COL8 = "prevHash";

    public StudentAccountStorage(Context context) {
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
                    COL5 + " NUMBER," +
                    COL6 + " BOOLEAN DEFAULT 0," +
                    COL7 + " TEXT," +
                    COL8 + " NUMBER DEFAULT 0" +
                ")";

        db.execSQL(sql);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean setBBC(Boolean paid, com.google.protobuf.ByteString prev_hash) {
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            db.execSQL("UPDATE studentaccount SET paid ='" + paid + "', date ='" + LocalDateTime.now() + "', prevHash ='" + prev_hash + "' WHERE ID = 1");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public Cursor getBBC() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT paid, date, prevHash FROM studentaccount WHERE ID = 1", null);
        return data;
    }

    public boolean insert(StudentAccount studentAccount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, studentAccount.getUsername());
        contentValues.put(COL3, studentAccount.getName());
        contentValues.put(COL4, studentAccount.getSurname());
        contentValues.put(COL5, studentAccount.getAge());

        Log.d(TAG, "insert: Inserting studentAccount into " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
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
