package com.example.trustchainproject.Main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.trustchainproject.R;

import java.sql.Connection;
import java.sql.DriverManager;

public class MainActivity extends AppCompatActivity {
    Context context;

    /**
     * Checks if there is already a username set in the past.
     * If there is one, it should be stored in the preferences.
     * Go directly to the next activity when there is one already.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

//        super.onCreate(savedInstanceState);
//        context = this;
//        if (UserNameStorage.getUserName(this) == null) {
//            setContentView(R.layout.user_configuration);
//            EditText userNameInput = findViewById(R.id.username);
//            userNameInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//                @Override
//                public void onFocusChange(View v, boolean hasFocus) {
//                    if (!hasFocus) {
//                        hideKeyboard(v);
//                    }
//                }
//            });
//        } else {
//            Intent myIntent = new Intent(this, FingerprintAuthActivity.class);
//            myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            this.startActivity(myIntent);
//        }
    }

    public void OnClickConfirm(View view) {
        Intent i = new Intent(this, FingerprintAuthActivity.class);
        this.startActivity(i);


//        EditText userNameInput = findViewById(R.id.username);
//        if (!userNameInput.getText().toString().matches("")) {
//            Intent myIntent = new Intent(this, FingerprintAuthActivity.class);
//            UserNameStorage.setUserName(context, userNameInput.getText().toString());
//            myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            this.startActivity(myIntent);
//        } else {
//            TextView userNot = findViewById(R.id.user_notification);
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                userNot.setTextColor(getResources().getColor(R.color.colorStatusCantConnect, null));
//            } else {
//                userNot.setTextColor(getResources().getColor(R.color.colorStatusCantConnect));
//            }
//            userNot.setText("Please fill in a username first!");
//        }
    }


//    public void hideKeyboard(View view) {
//        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
//        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
//    }
}