package nl.tudelft.cs4160.trustchain_android.Main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import nl.tudelft.cs4160.trustchain_android.Mock.DigiDMockService;
import nl.tudelft.cs4160.trustchain_android.R;
import nl.tudelft.cs4160.trustchain_android.SharedPreferences.UserNameStorage;
import nl.tudelft.cs4160.trustchain_android.Storage.Account;
import nl.tudelft.cs4160.trustchain_android.Storage.AccountStorage;

public class RegisterActivity extends AppCompatActivity {
    Context context;
    DigiDMockService digiDMockService;
    AccountStorage accountStorage;
    private TextView userMsg;


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

        if (!username.matches("") && !password.matches("")) {
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
        } else {
            userMsg.setText("Please fill the fields");
        }
    }
}
