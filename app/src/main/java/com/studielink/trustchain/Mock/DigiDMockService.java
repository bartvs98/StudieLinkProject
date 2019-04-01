package com.studielink.trustchain.Mock;

import android.content.Context;
import android.database.Cursor;

import com.studielink.trustchain.Storage.Account;

public class DigiDMockService {

    DigiDStorage digiDStorage;

    public DigiDMockService(Context context) {
        digiDStorage = new DigiDStorage(context);
    }

    public boolean checkExsitance(String username, String password) {
        return digiDStorage.checkAccExsitance(username, password);
    }

    public Account getAccountInfo(String username) {
        Cursor data = digiDStorage.getDataByUserName(username);

        while(data.moveToNext()){
            Account account = new Account(
                    data.getString(1),
                    data.getString(3),
                    data.getString(4),
                    data.getInt(5)
            );

            return account;
        }

        return null;
    }

}
