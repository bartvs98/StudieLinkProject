package com.studielink.trustchain.Main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.studielink.trustchain.R;
import com.studielink.trustchain.SharedPreferences.UserNameStorage;
import com.studielink.trustchain.Storage.AccountStorage;

public class RegisterActivity extends AppCompatActivity {
    Context context;
    AccountStorage accountStorage;

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
            EditText userNameInput = findViewById(R.id.username);
            userNameInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {
                        hideKeyboard(v);
                    }
                }
            });
        } else {
            Intent myIntent = new Intent(this, FingerprintAuthActivity.class);
            myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            this.startActivity(myIntent);
        }

    }

    public void OnClickConfirm(View view) {
        EditText userNameInput = findViewById(R.id.username);

        if (!userNameInput.getText().toString().matches("")) {
            Intent myIntent = new Intent(this, FingerprintAuthActivity.class);
            UserNameStorage.setUserName(context, userNameInput.getText().toString());

            accountStorage = new AccountStorage(this);
            accountStorage.insert(userNameInput.getText().toString());

            myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            this.startActivity(myIntent);
        }
    }

    /**
     * Hide the keyboard when the focus is not on the input field.
     * @param view the view that contains the input field.
     */
    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
