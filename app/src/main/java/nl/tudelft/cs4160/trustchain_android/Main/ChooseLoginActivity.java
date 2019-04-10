package nl.tudelft.cs4160.trustchain_android.Main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import nl.tudelft.cs4160.trustchain_android.R;
import nl.tudelft.cs4160.trustchain_android.SharedPreferences.LoginTypeStorage;

public class ChooseLoginActivity extends AppCompatActivity {
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;

        if (LoginTypeStorage.getLoginType(this) == null) {
            setContentView(R.layout.activity_choose_login_type);
        } else if (LoginTypeStorage.getLoginType(this).equals("student")) {
            Intent myIntent = new Intent(this, StudentRegisterActivity.class);
            myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            this.startActivity(myIntent);
            this.finish();
        } else if (LoginTypeStorage.getLoginType(this).equals("institution")) {
            Intent myIntent = new Intent(this, InstitutionLoginActivity.class);
            myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            this.startActivity(myIntent);
            this.finish();
        }

    }

    public void loginAsStudent(View view) {
        Intent myIntent = new Intent(this, StudentRegisterActivity.class);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.startActivity(myIntent);
        this.finish();
    }

    public void loginAsInstitution(View view) {
        Intent myIntent = new Intent(this, InstitutionLoginActivity.class);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.startActivity(myIntent);
        this.finish();
    }
}
