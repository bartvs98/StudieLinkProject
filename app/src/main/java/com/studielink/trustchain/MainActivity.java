package com.studielink.trustchain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    public void OnClickConfirm(View view) {
        Intent i = new Intent(this, FingerprintAuthActivity.class);
        this.startActivity(i);
    }
}
