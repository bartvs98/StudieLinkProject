package nl.tudelft.cs4160.trustchain_android.Main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import nl.tudelft.cs4160.trustchain_android.R;
import nl.tudelft.cs4160.trustchain_android.SharedPreferences.UserNameStorage;

public class ChooseLoginActivity extends AppCompatActivity {
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;

        if (UserNameStorage.getUserName(this) == null) {
            setContentView(R.layout.choose_login_type);
        } else {
            Intent myIntent = new Intent(this, FingerprintAuthActivity.class);
            myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            this.startActivity(myIntent);
        }

    }

    public void loginAsStudent(View view) {
        Intent myIntent = new Intent(this, StudentRegisterActivity.class);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.startActivity(myIntent);
    }

    public void loginAsInstitution(View view) {
        Intent myIntent = new Intent(this, InstitutionLoginActivity.class);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.startActivity(myIntent);
    }
}
