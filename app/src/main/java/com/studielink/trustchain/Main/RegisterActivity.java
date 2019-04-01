package com.studielink.trustchain.Main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.studielink.trustchain.Mock.DigiDMockService;
import com.studielink.trustchain.R;
import com.studielink.trustchain.SharedPreferences.UserNameStorage;
import com.studielink.trustchain.Storage.Account;
import com.studielink.trustchain.Storage.AccountStorage;

public class RegisterActivity extends AppCompatActivity {
    Context context;
    DigiDMockService digiDMockService;
    AccountStorage accountStorage;
    private TextView userMsg;

    /**
     * Checks if there is already a username set in the past.
     * If there is one, it should be stored in the preferences.
     * Go directly to the next activity when there is one already.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;

        if (UserNameStorage.getUserName(this) == null) {
            setContentView(R.layout.register_activity);
        } else {
            Intent myIntent = new Intent(this, FingerprintAuthActivity.class);
            myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            this.startActivity(myIntent);
        }

    }

    public void OnClickConfirm(View view) {
        EditText usernameInput = findViewById(R.id.username);
        EditText passwordInput = findViewById(R.id.password);
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();

        userMsg = findViewById(R.id.userMsg);

        if (!username.matches("")) {
            digiDMockService = new DigiDMockService(this);

            if (digiDMockService.checkExsitance(username, password)) {
                UserNameStorage.setUserName(context, username);

                Account loginResult = digiDMockService.getAccountInfo(username);
                accountStorage = new AccountStorage(this);
                accountStorage.insert(loginResult);

                Intent myIntent = new Intent(this, FingerprintAuthActivity.class);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                this.startActivity(myIntent);
            } else {
                userMsg.setText("Credentials incorrect.");
            }
        }
    }
}
