package nl.tudelft.cs4160.trustchain_android.Storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class InstitutionAccountStorage extends SQLiteOpenHelper {

    private static final String TAG = "InstitutionAccountStorage";

    private static final String TABLE_NAME = "institutionaccount";
    private static final String COL1 = "ID";
    private static final String COL2 = "username";
    private static final String COL3 = "password";
    private static final String COL4 = "name";

    public InstitutionAccountStorage(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME +
                "(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 + " TEXT, " +
                COL3 + " TEXT, " +
                COL4 + " TEXT" +
                ")";

        db.execSQL(sql);

        InstitutionAccount institutionAccount1 = new InstitutionAccount("HU", "admin01", "Hogeschool Utrecht");
        InstitutionAccount institutionAccount2 = new InstitutionAccount("UU", "admin01", "Universiteit Utrecht");

        insert(db, institutionAccount1);
        insert(db, institutionAccount2);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insert(SQLiteDatabase db,InstitutionAccount institutionAccount) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, institutionAccount.getUsername());
        contentValues.put(COL3, institutionAccount.getPassword());
        contentValues.put(COL4, institutionAccount.getName());

        Log.d(TAG, "insert: Inserting institutionAccount into " + TABLE_NAME);

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
