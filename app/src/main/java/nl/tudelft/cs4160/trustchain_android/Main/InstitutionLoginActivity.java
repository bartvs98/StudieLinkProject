package nl.tudelft.cs4160.trustchain_android.Main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import nl.tudelft.cs4160.trustchain_android.R;
import nl.tudelft.cs4160.trustchain_android.SharedPreferences.UserNameStorage;

public class InstitutionLoginActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;

        if (UserNameStorage.getUserName(this) == null) {
            setContentView(R.layout.activity_institution_login);
        } else {
            Intent myIntent = new Intent(this, OverviewConnectionsActivity.class);
            myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            this.startActivity(myIntent);
        }

    }

    public void LoginAsInstitution(View view) {
        EditText usernameInput = findViewById(R.id.username);
        EditText passwordInput = findViewById(R.id.password);
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();

        Intent myIntent = new Intent(this, OverviewConnectionsActivity.class);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.startActivity(myIntent);
    }
}
