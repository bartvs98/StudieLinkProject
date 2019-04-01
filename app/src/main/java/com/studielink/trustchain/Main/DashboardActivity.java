package com.studielink.trustchain.Main;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.studielink.trustchain.R;
import com.studielink.trustchain.SharedPreferences.UserNameStorage;
import com.studielink.trustchain.Storage.AccountStorage;

public class DashboardActivity extends AppCompatActivity {
    AccountStorage accountStorage;
    private TextView usernameData;
    private TextView nameData;
    private TextView ageData;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        accountStorage = new AccountStorage(this);
        usernameData = findViewById(R.id.usernameData);
        nameData = findViewById(R.id.nameData);
        ageData = findViewById(R.id.ageData);

        Cursor data = accountStorage.getDataByUserName(UserNameStorage.getUserName(this));
        while(data.moveToNext()){
            usernameData.setText(data.getString(1));
            nameData.setText(data.getString(3) + " " + data.getString(4));
            ageData.setText(data.getString(5));
        }
    }
}
