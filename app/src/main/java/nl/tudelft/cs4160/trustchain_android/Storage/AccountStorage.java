package nl.tudelft.cs4160.trustchain_android.Storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class AccountStorage extends SQLiteOpenHelper {

    private static final String TAG = "AccountStorage";

    private static final String TABLE_NAME = "account";
    private static final String COL1 = "ID";
    private static final String COL2 = "username";
    private static final String COL3 = "name";
    private static final String COL4 = "surname";
    private static final String COL5 = "age";

    public AccountStorage(Context context) {
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
                    COL5 + " NUMBER" +
                ")";

        db.execSQL(sql);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insert(Account account) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, account.getUsername());
        contentValues.put(COL3, account.getName());
        contentValues.put(COL4, account.getSurname());
        contentValues.put(COL5, account.getAge());

        Log.d(TAG, "insert: Inserting account into " + TABLE_NAME);

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