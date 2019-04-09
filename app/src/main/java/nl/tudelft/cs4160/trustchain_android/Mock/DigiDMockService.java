package nl.tudelft.cs4160.trustchain_android.Mock;

import android.content.Context;
import android.database.Cursor;

import nl.tudelft.cs4160.trustchain_android.Storage.StudentAccount;

public class DigiDMockService {

    DigiDStorage digiDStorage;

    public DigiDMockService(Context context) {
        digiDStorage = new DigiDStorage(context);
    }

    public boolean checkExsitance(String username, String password) {
        return digiDStorage.checkAccExsitance(username, password);
    }

    public StudentAccount getAccountInfo(String username) {
        Cursor data = digiDStorage.getDataByUserName(username);

        while(data.moveToNext()){
            StudentAccount studentAccount = new StudentAccount(
                    data.getString(1),
                    data.getString(3),
                    data.getString(4),
                    data.getInt(5)
            );

            return studentAccount;
        }

        return null;
    }

}
